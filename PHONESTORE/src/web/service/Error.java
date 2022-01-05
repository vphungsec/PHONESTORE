package web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import web.entity.CustomerEntity;
import web.entity.ProductEntity;
import web.model.MailObject;

public class Error {

	private Integer MIN_PHONE_LENGTH = 10;
	private Integer MAX_PHONE_LENGTH = 15;
	private Integer MIN_PWD_LENGTH = 4;
	
	private Integer MIN_PRODUCT_PRICE = 0;
	private Integer MAX_PRODUCT_PRICE = 500000000;
	private Integer MIN_INVENTORY_NUM = 1;
	private Integer MAX_INVENTORY_NUM = 5000;

	public Boolean isNumber(String str) {
		return str.matches("[0-9]+") ? true : false;
	}
	
	public String isPhoneFormat(String phone) {
		if (isNumber(phone.trim())) {
			if ((phone.trim().length() >= MIN_PHONE_LENGTH) && (phone.trim().length() <= MAX_PHONE_LENGTH)) {
				return null;
			} else {
				return "Phone at least " + MIN_PHONE_LENGTH + " chars, max " + MAX_PHONE_LENGTH + " chars";
			}
		} else {
			return "Phone not include alphabets";
		}				
	}	
	
	public String pwdError(String password) {		
		if (password.length() < MIN_PWD_LENGTH) {
			return "Password at least " + MIN_PWD_LENGTH + " chars";
		}
		return null;
	}
	
	public String pwdCompareError(String pwd1, String pwd2) {		
		if (pwd1.length() < MIN_PWD_LENGTH || pwd2.length() < MIN_PWD_LENGTH) {
			return "Password at least " + MIN_PWD_LENGTH + " chars";
		} else if (!pwd1.equals(pwd2)) {
			return "Two passwords are not equal";
		}
		return null;
	}
	
	public boolean nullCustomerError(CustomerEntity customer, String pwd2) {		
		if (customer.getfName().trim().length() <= 0) return true;
		if (customer.getlName().trim().length() <= 0) return true;
		if (customer.getAddress().trim().length() <= 0) return true;
		if (customer.getPhone().trim().length() <= 0) return true;
		if (customer.getPassword().trim().length() <= 0) return true;
		if (pwd2.trim().length() <= 0) return true;
		else return false;
	}
	
	public boolean nullProductError(ProductEntity product) {		
		if (product.getName().trim().length() <= 0) return true;
		if (product.getPrice() == null || product.getPrice() <= 0) return true;
		if (product.getInventoryNum() == null || product.getInventoryNum() < 0) return true;
		else return false;
	}
	
	public boolean nullMailObjectError(MailObject mail) {		
		if (mail.getSenderName().trim().length() <= 0) return true;
		if (mail.getRecipientMail().length() <= 0) return true;
		if (mail.getSubject().length() < 0) return true;
		if (mail.getMessageBody().length() < 0) return true;
		else return false;
	}
	
	public String productError(ProductEntity product) {		
		if (product.getPrice() < MIN_PRODUCT_PRICE || product.getPrice() > MAX_PRODUCT_PRICE) {
			return "Min product price is " + MIN_PRODUCT_PRICE + ", max is " + MAX_PRODUCT_PRICE;
		}
		if (product.getInventoryNum() < MIN_INVENTORY_NUM || product.getInventoryNum() > MAX_INVENTORY_NUM) {
			return "Min inventory num is " + MIN_INVENTORY_NUM + ", max is " + MAX_INVENTORY_NUM;
		}
		return null;
	}
	
	//add new function below here
	
	
	
	

	// function not used
	public boolean validateJavaDate(String strDate) {
		/* Check if date is 'null' */
		if (strDate.trim().equals("")) {
			return true;
		}
		/* Date is not 'null' */
		else {
			/*
			 * Set preferred date format, For example MM-dd-yyyy,
			 * MM.dd.yyyy,dd.MM.yyyy etc.
			 */
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			sdfrmt.setLenient(false);
			/*
			 * Create Date object parse the string into date
			 */
			try {
				Date javaDate = sdfrmt.parse(strDate);
			}
			/* Date format is invalid */
			catch (ParseException e) {
				return false;
			}
			/* Return true if date format is valid */
			return true;
		}
	}
}
