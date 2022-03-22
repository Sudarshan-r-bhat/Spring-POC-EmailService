package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmailChainService {

	private static final Logger log = LoggerFactory.getLogger(EmailChainService.class);

	@Autowired
	private EmailChainCreator chainCreator;

	private boolean valid = false;

	// To get and execute the chain
	public boolean validateUser(EmailUser user ) {
	
		try {
			EmailProcessor chain = chainCreator.getChains();
			valid = chain.isValid(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return valid;
		}
		
		return valid;
	}

}
