package com.filosofiadelsoftware.hexagonal.application.exception;

public class CuentaNoExisteException extends RuntimeException {

  public CuentaNoExisteException(int cuenta) {
    super("La cuenta " + cuenta + ", no es una cuenta valida");
  }
}
