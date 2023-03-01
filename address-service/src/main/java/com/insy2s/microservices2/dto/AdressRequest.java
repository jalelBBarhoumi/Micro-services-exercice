package com.insy2s.microservices2.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AdressRequest {
    private String ville;
    private String rue;
    private Long codePostal;
}
