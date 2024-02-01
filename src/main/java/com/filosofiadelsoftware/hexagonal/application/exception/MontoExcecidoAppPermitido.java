package com.filosofiadelsoftware.hexagonal.application.exception;

public class MontoExcecidoAppPermitido extends RuntimeException {


  public MontoExcecidoAppPermitido(int monto) {
    super(" monto sds "+monto);
  }
}
