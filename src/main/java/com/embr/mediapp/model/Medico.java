package com.embr.mediapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //name se puede como un save AS
@Table(name = "medico")
@Getter @Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column (name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Column (name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    @Column(name = "cmp", nullable = false, length = 12, unique = true)
    private String cmp;

    @Column(name = "fotourl", nullable = false, length = 70)
    private String fotoUrl;
}
