package com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.adapter.repository;

import com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.orm.TransferenciaORM;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaJPARepository extends JpaRepository<TransferenciaORM, UUID> {

}
