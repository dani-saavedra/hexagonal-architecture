package com.filosofiadelsoftware.hexagonal.infraestructure.out.dto;

public record ErrorDTO(String message, int codigoHTTP, String error) {

}
