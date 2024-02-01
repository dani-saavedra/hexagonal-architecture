package com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter;

import com.filosofiadelsoftware.hexagonal.domain.entity.Cuenta;
import com.filosofiadelsoftware.hexagonal.domain.repository.TransferenciaPort;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaAdapterRepository implements TransferenciaPort {

  private TransferenciaPort repository;

  public TransferenciaAdapterRepository(TransferenciaPort repository) {
    this.repository = repository;
  }

  @Override
  public UUID guardarTransaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, int monto) {
    //mapear hacia la base de datos. almacenamos,
    return UUID.randomUUID();
  }
}
