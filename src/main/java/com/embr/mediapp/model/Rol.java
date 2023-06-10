package com.embr.mediapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rol")
@Getter @Setter
public class Rol {

    @Id
    private Integer idRol;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "descripcion",nullable = true, length = 150)
    private String descripcion;
}
