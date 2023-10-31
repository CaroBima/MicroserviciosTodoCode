package com.clinica.pacientes.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
/**
 * Representa un paciente de la clínica.
 *
 * Esta clase encapsula la información detallada de un paciente, incluyendo dni, nombre, apellido,
 * fecha de nacimiento y teléfono
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String telefono;


}
