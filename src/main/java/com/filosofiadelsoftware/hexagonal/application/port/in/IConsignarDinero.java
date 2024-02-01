package com.filosofiadelsoftware.hexagonal.application.port.in;

import co.edu.unisabana.example.hexagonal.application.usecase.ConsignarDTO;

public interface IConsignarDinero {

  void consignarDinero(ConsignarDTO dto);
}
