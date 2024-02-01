package com.filosofiadelsoftware.hexagonal.infraestructure.out.persistence.orm;


import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TransferenciaORM {

  @Id
  @Column
  private UUID uuid;

  @Column
  private LocalDateTime fechaTransferencia;

  @JoinColumn
  @ManyToOne
  private CuentaORM cuentaOrigen;

  @JoinColumn
  @ManyToOne
  private CuentaORM cuentaDestino;

  @Column
  private int monto;

}
