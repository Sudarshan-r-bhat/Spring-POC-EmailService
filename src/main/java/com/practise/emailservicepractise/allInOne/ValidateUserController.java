package com.practise.emailservicepractise.allInOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/validate")
public class ValidateUserController {
	
	@Autowired
	EmailChainService emailChainService;
	
	
	@RequestMapping( method = RequestMethod.POST )
	public ResponseEntity<?> validateUser(@RequestBody EmailUser user ) {
	
		boolean valid = emailChainService.validateUser(user);
		
		if( valid )
			return new ResponseEntity(valid, HttpStatus.OK);
		else 
			return new ResponseEntity(valid, HttpStatus.NOT_ACCEPTABLE);
	}
	

}
