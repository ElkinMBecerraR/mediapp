package com.embr.mediapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "vehiculo", schema = "pruebas")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

    @Column(name="marca", nullable = false, length = 30)
     private String marca;

    @Column(name="modelo", nullable = false, length = 4)
     private String modelo;

    @Column(name="placa", nullable = false, length = 7)
     private String placa;

    @Column(name = "color", length = 50)
     private String color;
}
