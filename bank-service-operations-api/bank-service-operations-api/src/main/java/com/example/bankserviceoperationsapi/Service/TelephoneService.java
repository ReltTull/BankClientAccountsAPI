package com.example.bankserviceoperationsapi.Service;

import com.example.bankserviceoperationsapi.Entity.Telephone;
import com.example.bankserviceoperationsapi.Repository.TelephoneRepository;
import com.example.bankserviceoperationsapi.exceptions.DuplicateValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelephoneService {
    @Autowired
    private TelephoneRepository telephoneRepository;
    @Transactional
    public Telephone createTelephone(Telephone telephone) {
        for (Telephone t: telephoneRepository.findAll()) {
            if (telephone.getPhoneNumber().equals(t.getPhoneNumber())) {
                throw new DuplicateValueException("The phone number has already been registered");
            }
        }
        return telephoneRepository.save(telephone);
    }
    @Transactional
    public void deleteById(Long id) {
        telephoneRepository.deleteById(id);
    }
    @Transactional
    public void deleteAllTelephones() {
        telephoneRepository.deleteAll();
    }

    public synchronized Iterable<Telephone> getAllTelephones() {
        return telephoneRepository.findAll();
    }
}
