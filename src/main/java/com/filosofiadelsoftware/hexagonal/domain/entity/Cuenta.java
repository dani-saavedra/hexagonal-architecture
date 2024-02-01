package com.filosofiadelsoftware.hexagonal.domain.entity;

import com.filosofiadelsoftware.hexagonal.domain.enums.EstadoCuenta;
import com.filosofiadelsoftware.hexagonal.domain.enums.TipoCuenta;
import com.filosofiadelsoftware.hexagonal.domain.exception.CuentaInahabilitadaException;
import com.filosofiadelsoftware.hexagonal.domain.exception.SaldoInsuficienteException;

public class Cuenta {

  private int numeroCuenta;

  private EstadoCuenta estado;

  private int saldo;

  private int propietario;

  private TipoCuenta tipoCuenta;



  public Cuenta(int numeroCuenta, int saldo, int propietario, TipoCuenta tipoCuenta) {
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldo;
    this.propietario = propietario;
    this.tipoCuenta = tipoCuenta;
  }

  public void consignarDinero(int consignar) {
    validarEstadoCuenta();
    this.saldo = saldo + consignar;
  }

  public void retirarDinero(int dineroRetirar) {
    validarEstadoCuenta();
    if (dineroRetirar > this.saldo &&
        (!TipoCuenta.CORRIENTE.equals(this.tipoCuenta)
            || this.saldo - dineroRetirar > 100)) {
      throw new SaldoInsuficienteException(this.numeroCuenta, dineroRetirar);
    }
    this.saldo = this.saldo - dineroRetirar;
  }

  private void validarEstadoCuenta() {
    if (EstadoCuenta.DISPONIBLE.equals(estado)) {
      throw new CuentaInahabilitadaException(this.numeroCuenta);
    }
  }

  public int getNumeroCuenta() {
    return numeroCuenta;
  }

  public EstadoCuenta getEstado() {
    return estado;
  }

  public int getSaldo() {
    return saldo;
  }
}
