package com.filosofiadelsoftware.hexagonal.application.usecase;

import com.filosofiadelsoftware.hexagonal.application.port.in.IConsignarDinero;
import com.filosofiadelsoftware.hexagonal.application.port.in.ITransferirDinero;
import com.filosofiadelsoftware.hexagonal.domain.repository.TransferenciaPort;
import com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter.repository.CuentaRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class MovimientosUseCase implements ITransferirDinero, IConsignarDinero {

  public static final int MONTO_MAXIMO_HABILITADO_EN_APPLICACION = 1000000;
  private final CuentaRepository cuentaRepository;
  private final TransferenciaPort transferenciaPort;

  public MovimientosUseCase(CuentaRepository cuentaRepository,
      TransferenciaPort transferenciaPort) {
    this.cuentaRepository = cuentaRepository;
    this.transferenciaPort = transferenciaPort;
  }

  @Override
  public UUID transferirDinero(int cuentaOrigen, int cuentaDestino, int monto) {
    if (monto > MONTO_MAXIMO_HABILITADO_EN_APPLICACION) {
      throw new MontoExcecidoAppPermitido(monto);
    }
    Cuenta origen = cuentaRepository.obtenerCuenta(cuentaOrigen);
    Cuenta destino = cuentaRepository.obtenerCuenta(cuentaDestino);

    origen.retirarDinero(monto);
    destino.consignarDinero(monto);
    return transferenciaRepository.guardarTransaccion(origen, destino, monto);
  }


  @Override
  public void consignarDinero(ConsignarDTO dto) {
    Cuenta cuenta = cuentaRepository.obtenerCuenta(dto.cuenta);
    if (cuenta == null) {
      throw new CuentaNoExisteException(dto.cuenta);
    }
    cuenta.consignarDinero(dto.monto);
    cuentaRepository.actualizarSaldo(cuenta);
  }
}