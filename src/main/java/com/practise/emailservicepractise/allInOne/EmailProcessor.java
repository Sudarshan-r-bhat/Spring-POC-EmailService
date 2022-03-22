package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("emailProcessor")
public abstract class EmailProcessor {
	
	final static Logger log = LoggerFactory.getLogger(EmailProcessor.class);

	protected EmailProcessor nextValidator;

	public EmailProcessor() {

	}
	void setNextProcessor(EmailProcessor nextValidator) throws Exception {
		if(nextValidator != null ) {
			

			this.nextValidator = nextValidator;
			log.info("validating and passing the request {} ", this.nextValidator.getClass().getSimpleName());
		}
	}
	
	abstract boolean isValid(EmailUser userInfo) throws Exception;

}
