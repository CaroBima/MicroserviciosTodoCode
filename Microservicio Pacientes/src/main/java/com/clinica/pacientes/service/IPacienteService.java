package com.clinica.pacientes.service;

import com.clinica.pacientes.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interfaz que define operaciones para interactuar con pacientes en un servicio.
 * Proporciona métodos para obtener la información de los pacientes, para buscar datos de un paciente,
 * guardar nuevos pacientes, editarlos y borrarlos
 *
 * @see Paciente
 */

@Service
public interface IPacienteService {
    /**
     * Obtiene un listado de pacientes de la base de datos y lo devuelve
     * @return List<Paciente> Lista de pacientes que se encuentran guardados en la base de datos.
     */
    public List<Paciente> getPacientes();

    /**
     * Guarda un paciente en la base de datos
     * @param pac Paciente que va a ser guardado en la base de datos
     */
    public void savePaciente(Paciente pac);

    /**
     * Permite borrar los datos de un paciente.
     * @param id Valor que identifica al paciente cuyos datos van a ser borrados
     */
    public void deletePaciente(Long id);

    /**
     * Devuelve un paciente buscándolo por su id
     * @param id Valor que identifica al paciente cuyos datos van a ser borrados
     * @return Paciente Devuelve los datos del paciente guardado en la base de datos o null en caso de que el mismo
     * no se encuentre registrado
     */
    public Paciente findPaciente(Long id);

    /**
     * Permite guardar los datos modificados de un paciente
     *
     * @param id_original
     * @param pac         Paciente cuyos datos han sido editados y que van a ser guardados en la base de datos
     */
    public void editPaciente(Long id_original, Paciente pac);

    Paciente findPacienteDni(String dni);
}
