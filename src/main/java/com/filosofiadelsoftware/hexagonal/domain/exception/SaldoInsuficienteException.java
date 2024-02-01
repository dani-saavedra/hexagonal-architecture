package com.filosofiadelsoftware.hexagonal.domain.exception;

public class SaldoInsuficienteException extends RuntimeException {


  public SaldoInsuficienteException(int cuenta, int monto) {
    super("La cuenta " + cuenta + " no puede retirar " + monto);
  }
}
