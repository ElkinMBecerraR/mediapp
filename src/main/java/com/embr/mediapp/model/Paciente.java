package com.embr.mediapp.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table (name = "paciente") // Schema
public class Paciente {
    @Id //Especifica que es la primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para ser auto incremental
     private Integer idPaciente;

    @NotEmpty
    @Size(min = 3, message = "{nombres.size}")
    @Column(name = "nombres", nullable = false, length = 70)
     private String nombres;

    @Size(min = 3, message = "{apellidos.size}")
    @Column(name = "apellidos", nullable = false, length = 70)
     private String apellidos;

    @Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
    @Column(name = "dni", nullable = false, length = 10)
     private String dni;

    @Size(min = 9, max = 9, message = "direccion debe tener 9 caracteres")
    @Column(name = "direccion", nullable = true, length = 150)
     private String direccion;

    @Size(min = 10, max = 10, message = "El telefono debe tener 10 caracteres")
    @Column(name = "telefono", nullable = true, length = 10)
     private String telefono;

    @Email(message = "Formato incorrecto del Correo")
    @Column(name = "email", nullable = true, length = 55)
     private String email;

}
