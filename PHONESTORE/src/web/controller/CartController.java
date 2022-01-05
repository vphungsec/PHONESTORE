package web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.entity.CartEntity;
import web.entity.CustomerEntity;
import web.entity.ProductEntity;
import web.entity.SaleEntity;
import web.entity.StaffEntity;
import web.model.Account;
import web.service.DBService;

@Transactional
@Controller
@RequestMapping("/cart/")
public class CartController {
	
	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index(ModelMap model, HttpServletRequest req) {		
		
		try{
			
			HttpSession s = req.getSession();
			String userType = (String) s.getAttribute("userType");
			
			if (userType != null) {
				Account account = (Account) s.getAttribute("account");
				List<CartEntity> cardList;
				List<SaleEntity> sales;
				if (account != null) {
					DBService db = new DBService(factory);
					cardList = db.getCartsByPhone(account.getPhone());
					model.addAttribute("cardList", cardList);
					
					sales = db.getAllSale();
					model.addAttribute("sales", sales);
					
					if (userType.equals("customer")) {
						CustomerEntity customer = db.getCustomerByPhone(account.getPhone());
						model.addAttribute("customer", customer);
					}
					if (userType.equals("staff")) {
						StaffEntity staff = db.getStaffByPhone(account.getPhone());
						model.addAttribute("staff", staff);
					}							
					
				} else {
					cardList = new ArrayList<>();
					model.addAttribute("cardList", cardList);
					sales = new ArrayList<>();
					model.addAttribute("sales", sales);
				}	
			} else {
				return "redirect:/signin/index.htm";
			}
			
		} catch (Exception e) {
			return "redirect:/signin/index.htm";
		}
		return "cart/index";
	}
	
	@RequestMapping(value = "addcart/{id}", params = "linkAddCart")
	public String addCart(ModelMap model,
			HttpServletRequest req,
			@PathVariable("id") Integer id) {
		HttpSession s = req.getSession();
		Account account = (Account) s.getAttribute("account");
		
		if (id != null && account != null) {		
			DBService db = new DBService(factory);			
			ProductEntity product = db.getProduct(id);			
			
			if (product != null) {
				
				CartEntity cartTmp = db.getCartByPhoneAndProduct(account.getPhone(), id);
				
				if (cartTmp != null) {										
					db.deleteCart(cartTmp.getId());
				} else {
					CartEntity cart = new CartEntity();
					cart.setPhone(account.getPhone());
					cart.setProduct(product);
					cart.setAmount(1);
					
					db.insertCart(cart);
				}
			}
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "deletecart/{id}", params = "linkDeleteCart")
	public String deleteCart(ModelMap model,
			@PathVariable("id") Integer id) {
		
		DBService db = new DBService(factory);
		Integer temp = db.deleteCart(id);
		if (temp != 0) {
			return "redirect:/cart/index.htm";
		}
		
		return "cart/index";
	}
	
	
}