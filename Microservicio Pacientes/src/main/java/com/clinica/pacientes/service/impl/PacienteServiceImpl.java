package com.clinica.pacientes.service.impl;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.repository.IPacienteRepository;
import com.clinica.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implementación de la interfaz {@link IPacienteService}.
 * PacienteServiceImpl es un servicio que proporciona métodos para obtener información de los pacientes,
 * guardar la información de nuevos pacientes, editar la info de pacientes previamente guardados y también borrarlos
 *
 * @see IPacienteService
 * @see Paciente
 */

@Component
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private RestTemplate apiConsumir;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepository.save(pac);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editPaciente(Long id_original, Paciente pac) {
        this.savePaciente(pac);
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacienteRepository.findByDni(dni);
    }
}
