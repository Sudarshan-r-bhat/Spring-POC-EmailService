package com.practise.emailservicepractise.allInOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    // To send mail and to store the User in the H2 database.
    public void sendMail(EmailUser user) throws MailException {

        // this is to create MIME mail message. Multipurpose internet Mail extension (MIME).
        // JavaMailSenderImpl.class can be used to create MIME messages.

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(user.getEmailId());
        simpleMailMessage.setSubject("Registration Confirmation");
        simpleMailMessage.setText("Congratulations! " + user.getEmailId() + " you are now" +
                "registered to all our Exclusive services!");

        try {

            javaMailSender.send(simpleMailMessage);
            log.info("Service: an email is sent to the specified user's email address.");

        } catch( MailException e) {
            log.info(" Its our fault, mail couldn't be sent :( {} ", e.getMessage());
        }

    }
}
