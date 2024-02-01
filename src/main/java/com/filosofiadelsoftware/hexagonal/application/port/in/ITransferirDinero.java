package com.filosofiadelsoftware.hexagonal.application.port.in;

import java.util.UUID;

public interface ITransferirDinero {


  UUID transferirDinero(int cuentaOrigen, int cuentaDestino, int monto);
}
