package web.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.entity.CustomerEntity;
import web.entity.StaffEntity;
import web.model.Account;
import web.model.Gender;
import web.service.DBService;
import web.service.Error;
import web.service.Helper;

@Transactional
@Controller
@RequestMapping("/signin/")
public class SignInController {	
	
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index() {
		return "signin/index";
	}

	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String index(ModelMap model, HttpServletRequest req, HttpServletResponse res,
			@RequestParam("phone") String phone, @RequestParam("password") String password) {

		Error err = new Error();
		
		String errMsg = err.isPhoneFormat(phone);
		if (errMsg != null) {
			model.addAttribute("message", errMsg);
			return "signin/index";
		}
		
		errMsg = err.pwdError(password);
		if (errMsg != null) {
			model.addAttribute("message", errMsg);
			return "signin/index";
		}
		
		String encryptedPwd = new Helper().encryptPassword(password);

		DBService db = new DBService(factory);
		List<CustomerEntity> customers = db.getAllCustomer();
		boolean exist = false;

		for (CustomerEntity i : customers) {
			if (phone.trim().equals(i.getPhone().trim()) && encryptedPwd.equals(i.getPassword())) {
				exist = true;
				
				Account account = new Account();
				account.setId(i.getId());
				account.setPhone(i.getPhone());
				
				HttpSession s = req.getSession();
				s.setAttribute("userType", "customer");
				s.setAttribute("account", account);
				return "redirect:/";
			}
		}

		if (exist == false) {
			List<StaffEntity> staffs = db.getAllStaff();

			for (StaffEntity i : staffs) {
				if (phone.trim().equals(i.getPhone().trim()) && encryptedPwd.equals(i.getPassword())) {
					exist = true;
					
					Account account = new Account();
					account.setId(i.getId());
					account.setPhone(i.getPhone().trim());
					
					HttpSession s = req.getSession();
					s.setAttribute("userType", "staff");
					s.setAttribute("account", account);
					return "redirect:/";
				}
			}
		}

		if (exist == false) {
			model.addAttribute("message", "Phone or Password is invalid");
		}				

		return "signin/index";
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUp(ModelMap model) {
		model.addAttribute("customer", new CustomerEntity());
		return "signin/signup";
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUp(ModelMap model, HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("customer") CustomerEntity customer, @RequestParam("re_password") String re_password) {

		Error err = new Error();
		
		if (err.nullCustomerError(customer, re_password)) {
			model.addAttribute("nullMsg", "*");			
			return "signin/signup";
		}
		
		String errMsg = err.isPhoneFormat(customer.getPhone());
		if (errMsg != null) {
			model.addAttribute("errMsg", errMsg);			
			return "signin/signup";
		}
		
		errMsg = err.pwdCompareError(customer.getPassword(), re_password);
		if (errMsg != null) {
			model.addAttribute("errMsg", errMsg);
			return "signin/signup";
		}
		
		DBService db = new DBService(factory);
		
		CustomerEntity cusExist = db.getCustomerByPhone(customer.getPhone().trim());
		
		if (cusExist != null) {
			model.addAttribute("errMsg", "Phone " + customer.getPhone().trim() + " was signed up");
			return "signin/signup";
		}
		
		
		String encryptedPwd = new Helper().encryptPassword(customer.getPassword());
		
		if (encryptedPwd != null) {
			
        	customer.setPassword(encryptedPwd);
    		Integer temp = db.insertCustomer(customer);
    		if (temp != 0) {
    			
    			CustomerEntity newCustomer = db.getCustomerByPhone(customer.getPhone().trim());
    			if (newCustomer != null) {
    				
    				Account account = new Account();
    				account.setId(newCustomer.getId());
    				account.setPhone(newCustomer.getPhone().trim());
    				
    				HttpSession s = req.getSession();
    				s.setAttribute("userType", "customer");
    				s.setAttribute("account", account);
    				
        			return "redirect:/";
    			}
    		}
        }                
        
        return "signin/signup";
	}

	@ModelAttribute("genders")
	public List<Gender> getGenders() {
		List<Gender> genders = new ArrayList<>();
		genders.add(new Gender(0, "Female"));
		genders.add(new Gender(1, "Male"));
		return genders;
	}

	@RequestMapping(value="signout/{id}")
	public String signOut(@PathVariable("id") Integer id, HttpServletRequest req) {
		HttpSession s = req.getSession();
		s.setAttribute("userType", null);
		return "redirect:/";
	}

}
