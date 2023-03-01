package com.insy2s.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service", url = "http://localhost:8081/api/adress")
public interface APIClient {
    @GetMapping(value="/addresses/{id}")
    Boolean getAddress(@PathVariable("id") Long idAdress);
}
