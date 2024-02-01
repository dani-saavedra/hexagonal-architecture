package com.filosofiadelsoftware.hexagonal.infraestructure.in;

import co.edu.unisabana.example.hexagonal.application.usecase.ConsignarDTO;
import com.filosofiadelsoftware.hexagonal.application.port.in.IConsignarDinero;
import com.filosofiadelsoftware.hexagonal.application.usecase.ConsignarDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final IConsignarDinero consignacion;

  public AccountController(IConsignarDinero consignacion) {
    this.consignacion = consignacion;
  }

  @PostMapping(path = "/consignar")
  public void consignarDinero(@RequestBody ConsignarDTO consignarDTO) {
    consignacion.consignarDinero(consignarDTO);
  }
}
