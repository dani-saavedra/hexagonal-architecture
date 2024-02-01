package com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter.repository;

import com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.orm.CuentaORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaORM, Integer> {

}
