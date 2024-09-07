package com.example.bankserviceoperationsapi.Controller;

import com.example.bankserviceoperationsapi.Entity.Telephone;
import com.example.bankserviceoperationsapi.Service.TelephoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/telephones")
public class TelephoneController {
    @Autowired
    private TelephoneService telephoneService;

    @PostMapping("/createNewTelephone")
    public Telephone createNewTelephone(@RequestBody Telephone telephone) {
        return telephoneService.createTelephone(telephone);
    }

    @DeleteMapping("/deleteById")
    public void deleteTelephoneById(@RequestBody Telephone telephone) {
        log.info(telephone.getId() + " has been removed");
        telephoneService.deleteById(telephone.getId());
    }

    @DeleteMapping("/deleteAllTelephones")
    public void deleteAllTelephones() {
        log.info("Telephones has been removed");
        telephoneService.deleteAllTelephones();
    }

    @GetMapping("/getAllTelephones")
    public Iterable<Telephone> getAllTelephones() {
        return telephoneService.getAllTelephones();
    }
}
