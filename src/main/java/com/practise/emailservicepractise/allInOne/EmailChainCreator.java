package com.practise.emailservicepractise.allInOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailChainCreator {
	
//	@Autowired
//	@Qualifier("emailProcessor")
//	EmailProcessor emailProcessor;
	
	@Autowired
	@Qualifier("validateEmail")
	EmailProcessorChain1 emailValidator;
	
	@Autowired
	@Qualifier("validatePassword")
	EmailProcessorChain2 passwordValidator;
	
	@Autowired
	@Qualifier("finalChain")
	EmailProcessorChain3 finalStep;
	
	
	EmailProcessor getChains() throws Exception {
		
		EmailProcessor chain1 = emailValidator;
		EmailProcessor chain2 = passwordValidator;
		EmailProcessor chain3 = finalStep;
		
		// adding this verbosity for better readability
		
		chain1.setNextProcessor(chain2);
		chain2.setNextProcessor(chain3);
		chain3.setNextProcessor(null);
		
		return chain1;
	}
}
