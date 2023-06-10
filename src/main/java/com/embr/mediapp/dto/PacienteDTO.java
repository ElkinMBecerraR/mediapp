package com.embr.mediapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteDTO
{
    private Integer idPaciente;
    @NotEmpty
    @Size(min = 3, message = "{nombres.size}")
    private String nombres;

    @Size(min = 3, message = "{apellidos.size}")
    private String apellidos;

    @Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
    private String dni;

    @Size(min = 9, max = 9, message = "direccion debe tener 8 caracteres")
    private String direccion;

    @Size(min = 10, max = 10, message = "El telefono debe tener 10 caracteres")
    private String telefono;

    @Email(message = "Formato incorrecto del Correo")
    private String email;
}
