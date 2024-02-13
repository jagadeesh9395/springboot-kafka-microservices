package com.jagjava.emailservice.service;

import com.jagjava.basedomain.dto.MailStructure;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Value("${spring.mail.username}")
    private String fromEmail;


    private JavaMailSender mailSender;

    public SendMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String toMail, MailStructure mailStructure) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setSubject(mailStructure.getSubject());
        mailMessage.setText(mailStructure.getBody());
        mailMessage.setTo(toMail);
        mailSender.send(mailMessage);
        System.out.println("Sending mail to " + toMail + " with message " + mailStructure.getBody());
    }


}
