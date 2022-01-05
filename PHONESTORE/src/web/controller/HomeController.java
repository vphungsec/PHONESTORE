package web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.bean.Pagination;
import web.entity.BrandEntity;
import web.entity.CartEntity;
import web.entity.CustomerEntity;
import web.entity.ProductEntity;
import web.entity.StaffEntity;
import web.model.Account;
import web.service.DBService;

@Transactional
@Controller
public class HomeController {			
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	@Qualifier("pagination")
	Pagination basePagination;
	
	@RequestMapping("/index")
	public String index(ModelMap model,
			HttpServletRequest req,
			@ModelAttribute("product") ProductEntity product) {
		
		HttpSession s = req.getSession();
		String userType = (String) s.getAttribute("userType");
		
//		if (userType != null) {
			DBService db = new DBService(factory);
			List<ProductEntity> products = db.getAllProduct();

			PagedListHolder pagedListHolder = new PagedListHolder(products);
			int page = ServletRequestUtils.getIntParameter(req, "p", 0);
			pagedListHolder.setPage(page);
			pagedListHolder.setMaxLinkedPages(basePagination.getMaxLinkedPages());
			pagedListHolder.setPageSize(basePagination.getMaxRow() * basePagination.getMaxColumn());

			model.addAttribute("pagedListHolder", pagedListHolder);
			
			Account account = (Account) s.getAttribute("account");
			List<CartEntity> cardList;
			if (account != null) {
				cardList = db.getCartsByPhone(account.getPhone());
				model.addAttribute("cardList", cardList);
			} else {
				cardList = new ArrayList<>();
				model.addAttribute("cardList", cardList);
			}
//		} else {
//			return "redirect:/signin/index.htm";
//		}
		

		return "home/index";
	}
	
}
