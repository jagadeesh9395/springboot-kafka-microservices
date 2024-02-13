package com.jagjava.emailservice.controller;

import com.jagjava.basedomain.dto.MailStructure;
import com.jagjava.emailservice.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class SendMailController {

    @Autowired
    private SendMailService sendMailService;


    @PostMapping(value = "/sendMail/{toEmail}")
    public String sendMail(@PathVariable String toEmail, @RequestBody MailStructure mailStructure) {
        sendMailService.sendMail(toEmail, mailStructure);
        return "Mail Sent";
    }
}
