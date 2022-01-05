package web.controller;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("/bill/")
public class BillController {

	@Autowired
	SessionFactory factory;

	@RequestMapping("index")
	public String index() {
		return "bill/index";
	}
}