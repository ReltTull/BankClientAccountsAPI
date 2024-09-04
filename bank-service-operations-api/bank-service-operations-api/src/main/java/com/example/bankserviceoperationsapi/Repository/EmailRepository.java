package com.example.bankserviceoperationsapi.Repository;

import com.example.bankserviceoperationsapi.Entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface EmailRepository extends JpaRepository<Email, Long> {
}
