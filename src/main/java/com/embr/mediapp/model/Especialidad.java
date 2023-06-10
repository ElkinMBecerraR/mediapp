package com.embr.mediapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // name sobre nombre
@Table(name = "especialidad")
@Getter
@Setter
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidad;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
}
