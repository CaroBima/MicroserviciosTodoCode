package com.clinica.pacientes.controller;

import com.clinica.pacientes.model.Paciente;
import com.clinica.pacientes.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones relacionadas los pacientes.
 * Proporciona endpoints para obtener información de los pacientes de la clínica,
 * guardar datos de pacientes en la base de datos, editar los datos y borrarlos
 *
 * @see Paciente
 * @see IPacienteService
 */
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    /**
     * Permite crear un nuevo paciente
     * @param paciente
     * @return String informando creaccion del paciente
     */
    @PostMapping("/crear")
    public String crearPaciente(@RequestBody Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "Paciente creado correctamente";
    }

    /**
     * Obtiene el listado de todos los pacientes registrados
     * @return List<Paciente> Devuelve el listado de todos los pacientes
     */
    @GetMapping("/traer")
    public List<Paciente> traerPacientes(){
        return pacienteService.getPacientes();
    }

    @GetMapping("traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteService.findPacienteDni(dni);
    }
    /**
     * Permite borrar un paciente cuyo id se pasa por parámetro
     * @param id Clave identificatoria del paciente que se desea borrar de la base de datos
     * @return String informando que el borrado ha sido correcto
     */
    @DeleteMapping("/borrar/{id}")
    public String deletePaciente(@PathVariable Long id){
        pacienteService.deletePaciente(id);

        return "El paciente fue eliminado correctamente";
    }

    /**
     * Permite editar los datos de un paciente identificándolo por su Id
     * @param id_original Id original del paciente a editar
     * @param pacienteEditar Datos nuevos del paciente, editados
     * @return pacienteEditado Datos ya editados guardados en la base de datos
     */
    @PutMapping("/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                                 @RequestBody Paciente pacienteEditar){
        pacienteService.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteService.findPaciente(id_original);

        return pacienteEditado;
    }
}

