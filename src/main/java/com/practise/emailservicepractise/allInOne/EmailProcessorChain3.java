package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("finalChain")
public class EmailProcessorChain3 extends EmailProcessor {

	private static final Logger log = LoggerFactory.getLogger(EmailProcessorChain3.class);


	@Autowired
	EmailService service;

	@Override
	boolean isValid(EmailUser userInfo) throws Exception {
		
		boolean valid = true;
//
//		try {
//			// make a db criteria and store the details to the database.
//
//
//		} catch (Exception e) {
//			valid = false;
//
//
//		}
		
		try {
			// make a request to EmailService client to send the request....
			service.sendMail(userInfo);
			log.info("An email is sent to the user : {}" + userInfo.getEmailId());

		} catch (Exception e) {
			log.info("Failed to send the email : {}" + userInfo.getEmailId());
			valid = false;
		}
		
		
		return valid;
	}
	
	
	

}
