package com.embr.mediapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPK.class)
@Getter @Setter
public class ConsultaExamen {

    @Id
    private Consulta consulta;

    @Id
    private Examen examen;
}
