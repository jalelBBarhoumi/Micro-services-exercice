package com.insy2s.microservices2.repository;

import com.insy2s.microservices2.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adresse,Long> {
}
