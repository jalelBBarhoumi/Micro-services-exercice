package com.insy2s.microservices2.controller;

import com.insy2s.microservices2.dto.AdressRequest;
import com.insy2s.microservices2.model.Adresse;
import com.insy2s.microservices2.repository.AdressRepository;
import com.insy2s.microservices2.service.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@RestController
@RequestMapping("/api/adress")
@RequiredArgsConstructor

//@FeignClient(value = "ADDRESS-SERVICE", url = "http://localhost:8081")
public class AdressController {
    private final AdressService adressService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdress(@RequestBody AdressRequest adressRequest){
        adressService.createAdress(adressRequest);

    }
    @GetMapping
    public List<Adresse> getAllAdresses() {
        return adressService.getAllAdresses();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Adresse> getAdressById(@PathVariable Long id) {
        Adresse adresse = adressService.getAdressById(id);
        if(adresse != null) {
            return ResponseEntity.ok(adresse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Adresse> updateAdress(@PathVariable Long id, @RequestBody AdressRequest adressRequest) {
        Adresse updatedAdress = adressService.updateAdress(id, adressRequest);
        if(updatedAdress != null) {
            return ResponseEntity.ok(updatedAdress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdress(@PathVariable Long id) {
        adressService.deleteAdress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Adresse> getAddress(@PathVariable("id") Long id) {
        // Look up the address by ID in the address microservice's database
        Adresse address = adressService.getAdressById(id);
        if (address != null) {
            // If the address exists, return it with a success status code
            return ResponseEntity.ok(address);
        } else {
            // If the address doesn't exist, return a not found status code
            return ResponseEntity.notFound().build();
        }
    }





}
