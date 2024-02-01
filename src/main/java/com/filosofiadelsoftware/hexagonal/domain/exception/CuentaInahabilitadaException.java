package com.filosofiadelsoftware.hexagonal.domain.exception;

public class CuentaInahabilitadaException extends RuntimeException {


  public CuentaInahabilitadaException(int cuenta) {
    super("La cuenta " + cuenta + " se encuentra inhabiltiada");
  }

}
