package com.example.bankserviceoperationsapi.Controller;

import com.example.bankserviceoperationsapi.Entity.Email;
import com.example.bankserviceoperationsapi.Service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emails")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/createNewEmail")
    public Email createNewEmail(@RequestBody Email email) {
        return emailService.createNewEmail(email);
    }
}
