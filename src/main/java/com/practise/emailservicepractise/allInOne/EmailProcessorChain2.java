package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("validatePassword")
public class EmailProcessorChain2 extends EmailProcessor {

	final static Logger log = LoggerFactory.getLogger(EmailProcessorChain2.class);

	@Override
	boolean isValid(EmailUser user) throws Exception {

		String password = user.getPassword();
		boolean lengthConstraint = password.length() > 8 && password.length() < 15;
		boolean valid = password.matches("[\\w*@\\+]+");

		if (lengthConstraint && valid)
			try {
				log.info("password is valid and now storing the user info to DB and "
						+ "sending email confirmation.");
				this.nextValidator.isValid(user);

			} catch (Exception e) {
				log.info(" {}", e.getMessage());
			}
		else {
			log.info("Invalid password");
			throw new Exception("Invalid email address");
		}
		
		

		return (lengthConstraint && valid);
	}
}
