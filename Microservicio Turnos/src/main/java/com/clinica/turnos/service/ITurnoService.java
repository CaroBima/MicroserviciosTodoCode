package com.clinica.turnos.service;

import com.clinica.turnos.model.TurnoEntity;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    public List<TurnoEntity> getTurnos();
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);
    public void deleteTurno(Long id);
    public TurnoEntity findTurno(Long id);
    public void editTurno(Long id, TurnoEntity turno);

}
