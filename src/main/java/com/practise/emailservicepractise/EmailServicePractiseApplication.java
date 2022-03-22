package com.practise.emailservicepractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Arrays;

@SpringBootApplication
public class EmailServicePractiseApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmailServicePractiseApplication.class, args);
	}

}
