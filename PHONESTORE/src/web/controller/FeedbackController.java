package web.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.model.MailObject;
import web.service.Error;

@Transactional
@Controller
@RequestMapping("/feed/")
public class FeedbackController {
	
	@Autowired
	public JavaMailSender mailer;

	@RequestMapping(value = "mail", method = RequestMethod.GET)
	public String sendMail() {
		return "feed/mail";
	}
	
	@RequestMapping(value = "mail", method = RequestMethod.POST)
	public String sendMail(ModelMap model, @ModelAttribute("mailObject") MailObject mailObject) {
		
		Error err = new Error();
		if (!err.nullMailObjectError(mailObject)) {
			
			try {
				MimeMessage mail = mailer.createMimeMessage();
				MimeMessageHelper hepler = new  MimeMessageHelper(mail,true);
				
				hepler.setFrom("hunghardley0199@@gmail.com", mailObject.getSenderName());
				hepler.setTo(mailObject.getRecipientMail());
				hepler.setReplyTo("hunghardley0199@gmail.com");
				hepler.setSubject(mailObject.getSubject());
				hepler.setText(mailObject.getMessageBody(), true);						
				
				mailer.send(mail);
				model.addAttribute("error","Sent mail successfully");
				mailObject.setSenderName("");
				mailObject.setRecipientMail("");
				mailObject.setSubject("");
				mailObject.setMessageBody("");			
			} catch (Exception e) {
				model.addAttribute("error", "Sent mail unsuccessfully");
			}
			
		} else {
			model.addAttribute("nullMsg", "*");
		}
		
		return "feed/mail";
	}
	
}
