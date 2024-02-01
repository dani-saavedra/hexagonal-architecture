package com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter;

import com.filosofiadelsoftware.hexagonal.domain.entity.Cuenta;
import com.filosofiadelsoftware.hexagonal.domain.repository.CuentaPort;
import com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter.repository.CuentaRepository;
import com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.orm.CuentaORM;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CuentaAdapterRepository implements CuentaPort {

  private final CuentaRepository cuentaRepository;

  public CuentaAdapterRepository(
      CuentaRepository cuentaRepository) {
    this.cuentaRepository = cuentaRepository;
  }

  @Override
  public Cuenta obtenerCuenta(int numCuenta) {
    Optional<CuentaORM> byId = cuentaRepository.findById(numCuenta);
    byId.ifPresent(CuentaORM::converToModel);
    return null;
  }

  @Override
  public void actualizarSaldo(Cuenta cuenta) {
    CuentaORM cuentaORM = cuentaRepository.findById(cuenta.getNumeroCuenta()).get();
    cuentaORM.setSaldo(cuenta.getSaldo());
    cuentaRepository.save(cuentaORM);
  }
}
