package com.clinica.turnos.service.impl;

import com.clinica.turnos.model.Paciente;
import com.clinica.turnos.model.TurnoEntity;
import com.clinica.turnos.repository.ITurnoRepository;
import com.clinica.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoServiceImp implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    private RestTemplate apiConsumir;

    @Override
    public List<TurnoEntity> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        //buscar el paciente en la api de pacientes
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/" + dniPaciente, Paciente.class);
        String nombreCompletoPaciente = pac.getNombre() + " " + pac.getApellido();

        TurnoEntity turno = new TurnoEntity();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);

        turnoRepository.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoEntity findTurno(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, TurnoEntity turno) {
        TurnoEntity turnoModificado = this.findTurno(id);

        turnoModificado.setFecha(turno.getFecha());
        turnoModificado.setTratamiento(turno.getTratamiento());
        turnoModificado.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepository.save(turnoModificado);

    }
}
