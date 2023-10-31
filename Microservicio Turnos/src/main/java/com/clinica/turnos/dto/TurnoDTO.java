package com.clinica.turnos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {
    private LocalDate fecha;
    private String tratamiento;
    private String dniPaciente;
}
