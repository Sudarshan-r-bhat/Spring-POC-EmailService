package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("validateEmail")
public class EmailProcessorChain1 extends EmailProcessor {

	final static Logger log = LoggerFactory.getLogger(EmailProcessorChain1.class);
	
	@Override
	boolean isValid(EmailUser user) throws Exception {
		
		log.info("validating the user's email address.....");
		String email = user.getEmailId();
		boolean valid  = email.matches("[a-z._0-9]+@[(gmail.com)]*[(yahoo.com)]*");
		
		if(valid)
			try {
				log.info("Email address is valid and now validating the password.....");
				this.nextValidator.isValid(user);
			
			} catch (Exception e) {
				log.info(" {}", e.getMessage());
			}
		else {
			log.info("Invalid Email id");
			throw new Exception("Invalid email address");
		}
		
		return valid;
	}
	
	

}
