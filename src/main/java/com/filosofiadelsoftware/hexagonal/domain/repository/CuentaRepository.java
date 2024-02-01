package com.filosofiadelsoftware.hexagonal.domain.repository;

import com.filosofiadelsoftware.hexagonal.domain.entity.Cuenta;

public interface CuentaRepository {

  Cuenta obtenerCuenta(int numCuenta);

  void actualizarSaldo(Cuenta cuenta);
}
