package com.insy2s.microservices2.service;

import com.insy2s.microservices2.dto.AdressRequest;
import com.insy2s.microservices2.model.Adresse;
import com.insy2s.microservices2.repository.AdressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdressService {
    private final AdressRepository adressRepository;
    public void createAdress(AdressRequest adressRequest){
        Adresse adresse = Adresse.builder()
                .ville(adressRequest.getVille())
                .rue(adressRequest.getRue())
                .codePostal(adressRequest.getCodePostal())
                .build();
        adressRepository.save(adresse);
        log.info("adress "+adresse.getId()+"is saved ");
    }
    public List<Adresse> getAllAdresses() {
        return adressRepository.findAll();
    }
    public Adresse getAdressById(Long id) {
        Optional<Adresse> optionalAdresse = adressRepository.findById(id);
        return optionalAdresse.orElse(null);
    }
    public Adresse updateAdress(Long id, AdressRequest adressRequest) {
        Optional<Adresse> optionalAdresse = adressRepository.findById(id);
        if(optionalAdresse.isPresent()) {
            Adresse adresse = optionalAdresse.get();
            adresse.setVille(adressRequest.getVille());
            adresse.setRue(adressRequest.getRue());
            adresse.setCodePostal(adressRequest.getCodePostal());
            return adressRepository.save(adresse);
        } else {
            return null;
        }
    }

    public void deleteAdress(Long id) {
        adressRepository.deleteById(id);
    }




}
