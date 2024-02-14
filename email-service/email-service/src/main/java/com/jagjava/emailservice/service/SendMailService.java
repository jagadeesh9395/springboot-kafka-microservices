package com.jagjava.emailservice.service;

import com.jagjava.basedomain.dto.MailStructure;
import com.jagjava.basedomain.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class SendMailService {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SendMailService.class);
    @Value("${spring.mail.username}")
    private String fromEmail;


    private JavaMailSender mailSender;

    public SendMailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void sendMailFromTopic(  OrderEvent orderEvent) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo("jagadeeshwar.karanam@gmail.com");
        mailMessage.setText(orderEvent.getStatus());
        mailSender.send(mailMessage);
        LOGGER.info(MessageFormat.format("Sending mail to {0} with message {1}", mailMessage.getTo(), mailMessage.getText()));
    }

    public void sendMail(String toMail, MailStructure mailStructure) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setSubject(mailStructure.getSubject());
        mailMessage.setText(mailStructure.getBody());
        mailMessage.setTo(toMail);
        mailSender.send(mailMessage);
        LOGGER.info(MessageFormat.format("Sending mail to {0} with message {1}", toMail, mailStructure.getBody()));
    }
}
