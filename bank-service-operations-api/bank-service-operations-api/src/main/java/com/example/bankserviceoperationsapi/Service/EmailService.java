package com.example.bankserviceoperationsapi.Service;

import com.example.bankserviceoperationsapi.Entity.Email;
import com.example.bankserviceoperationsapi.Repository.EmailRepository;
import com.example.bankserviceoperationsapi.exceptions.DuplicateValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Transactional
    public Email createNewEmail(Email email) {
        for (Email e : emailRepository.findAll()) {
            if (email.getEmail().equals(e.getEmail())) {
                throw new DuplicateValueException("This email has already been registered");
            }
        }
        return emailRepository.save(email);
    }

    @Transactional
    public void deleteEmailById(Long id) {
        emailRepository.deleteById(id);
    }
}
