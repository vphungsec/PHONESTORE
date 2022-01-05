package web.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Helper {
	
	public String encryptPassword(String pwd) {
		String encryptedpassword = null;
		try {            
            MessageDigest m = MessageDigest.getInstance("MD5");  
                        
            m.update(pwd.getBytes());  
                        
            byte[] bytes = m.digest();  
                          
            StringBuilder s = new StringBuilder();  
            for(int i=0; i < bytes.length ; i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            
            encryptedpassword = s.toString();                       
            
        } catch (NoSuchAlgorithmException e) {
        	encryptedpassword = null;
            e.printStackTrace();  
        }
		
		return encryptedpassword;
	}
}
