package web.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.bean.UploadFile;
import web.entity.BrandEntity;
import web.entity.ProductEntity;
import web.model.Gender;
import web.service.DBService;
import web.service.Error;

@Transactional
@Controller
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	@Qualifier("uploadfile")
	UploadFile baseUploadFile;

	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("product", new ProductEntity());
		return "product/index";
	}
	
	@RequestMapping(value = "view/{id}", params = "linkView")
	public String viewProduct(ModelMap model,
			HttpServletRequest req,
			@PathVariable("id") Integer id) {
		
		DBService db = new DBService(factory);
		ProductEntity product = db.getProduct(id);
		
		model.addAttribute("product", product);
		
		return "product/view";
	}
	
	@RequestMapping(value = "edit/{id}", params = "linkEdit")
	public String editProduct(ModelMap model,
			HttpServletRequest req,
			@PathVariable("id") Integer id) {
		
		DBService db = new DBService(factory);
		ProductEntity product = db.getProduct(id);
		
		model.addAttribute("product", product);
		
		return "product/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editProduct(ModelMap model,
			@ModelAttribute("product") ProductEntity product,
			@RequestParam("file") MultipartFile file,
			BindingResult result) {				
		
		if (result.hasErrors()) {
			model.addAttribute("error", "Error updating product");
			return "product/edit";
		}
		
		Error err = new Error();			
		if (err.nullProductError(product)) {
			model.addAttribute("nullMsg", "*");
			return "product/edit";
		}
		
		String error = err.productError(product);
		if (error != null) {
			model.addAttribute("error", error);
			return "product/edit";
		}
		
		if(file.isEmpty()) {
			if (product.getImage().trim().length() <= 0) {
				model.addAttribute("uploadError","Please upload image");
				
			} else {
				
				try {
					DBService db = new DBService(factory);
					Integer temp = db.updateProduct(product);	
					if (temp != 0) {
						Thread.sleep(3000);
						return "redirect:/";
					} else {
						model.addAttribute("error", "Error updating product");
					}
				} catch (Exception e) {
					model.addAttribute("uploadError","Error uploading image");
					return "product/edit";
				}				
			}			
			
		} else {			
			
			try {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
				String fileName = date + file.getOriginalFilename();
				String photoPath = baseUploadFile.getBasePath() + File.separator + fileName;
				file.transferTo(new File(photoPath));
				
				DBService db = new DBService(factory);
				product.setImage(fileName);
				Integer temp = db.updateProduct(product);	
				if (temp != 0) {
					Thread.sleep(3000);
					return "redirect:/";
				} else {
					model.addAttribute("error", "Error updating product");
				}

			} catch (Exception e) {
				model.addAttribute("uploadError","Error uploading image");
				return "product/edit";
			}
		}				
		
		return "product/edit";				
	}
	
	@RequestMapping(value = "add")
	public String addProduct(ModelMap model) {		
		model.addAttribute("product", new ProductEntity());		
		return "product/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProduct(ModelMap model,
			@ModelAttribute("product") ProductEntity product,
			@RequestParam("file") MultipartFile file,
			BindingResult result) {		
		
		if (result.hasErrors()) {
			model.addAttribute("error", "Error creating product");
			return "product/add";
		}
		
		Error err = new Error();			
		if (err.nullProductError(product)) {
			model.addAttribute("nullMsg", "*");
			return "product/add";
		}
		
		String error = err.productError(product);
		if (error != null) {
			model.addAttribute("error", error);
			return "product/add";
		}
		
		if(file.isEmpty()) {
			model.addAttribute("error", "Please choose image");
			return "product/add";			
			
		} else {			
			
			try {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
				String fileName = date + file.getOriginalFilename();
				String photoPath = baseUploadFile.getBasePath() + File.separator + fileName;
				file.transferTo(new File(photoPath));
				
				DBService db = new DBService(factory);
				product.setImage(fileName);
				Integer temp = db.insertProduct(product);	
				if (temp != 0) {
					Thread.sleep(3000);
					return "redirect:/";
				} else {
					model.addAttribute("error", "Error updating product");
				}

			} catch (Exception e) {
				model.addAttribute("uploadError","Error uploading image");
				return "product/add";
			}
		}				
		
		return "product/add";				
	}
	
	
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	public String createProduct(ModelMap model,
//			@ModelAttribute("product") ProductEntity product,
//			@RequestParam("file") MultipartFile file,
//			BindingResult result) {
//		
//		if (result.hasErrors()) {
//			model.addAttribute("error", "Error updating product");
//			return "product/edit";
//		}
//		
//		if(file.isEmpty()) {
//			if (product.getImage().trim().length() <= 0) {
//				model.addAttribute("uploadError","Please upload image");
//				
//			} else {
//				
//				try {
//					DBService db = new DBService(factory);
//					Integer temp = db.updateProduct(product);	
//					if (temp != 0) {
//						Thread.sleep(3000);
//						return "redirect:/";
//					} else {
//						model.addAttribute("error", "Error updating product");
//					}
//				} catch (Exception e) {
//					model.addAttribute("uploadError","Error uploading image");
//					return "product/edit";
//				}				
//			}			
//			
//		} else {			
//			
//			try {
//				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
//				String fileName = date + file.getOriginalFilename();
//				String photoPath = baseUploadFile.getBasePath() + File.separator + fileName;
//				file.transferTo(new File(photoPath));
//				
//				DBService db = new DBService(factory);
//				product.setImage(fileName);
//				Integer temp = db.updateProduct(product);	
//				if (temp != 0) {
//					Thread.sleep(3000);
//					return "redirect:/";
//				} else {
//					model.addAttribute("error", "Error updating product");
//				}
//
//			} catch (Exception e) {
//				model.addAttribute("uploadError","Error uploading image");
//				return "product/edit";
//			}
//		}				
//		
//		return "product/edit";				
//	}
	
//	@RequestMapping(value = "addcart/{id}", params = "linkAddCart")
//	public String addCart(ModelMap model,
//			HttpServletRequest req,
//			@PathVariable("id") Integer id) {
//		
//		
//		
//		return "redirect:/";
//	}
	
	@RequestMapping(value = "delete/{id}", params = "linkDelete")
	public String deleteProduct(@PathVariable("id") Integer id) {
		
		DBService db = new DBService(factory);
		ProductEntity product = db.getProduct(id);
		Integer temp = db.deleteProduct(id);
		if (temp != 0) {
			File delFile = new File(baseUploadFile.getBasePath() + File.separator + product.getImage());
			delFile.delete() ;
		}

		return "redirect:/";
	}		
	
	@ModelAttribute("brands")
	public List<BrandEntity> getBrands() {		
		DBService db = new DBService(factory);
		List<BrandEntity> list = db.getAllBrand();				
		return list;
	}
	
}