package com.clinica.turnos.controller;

import com.clinica.turnos.model.TurnoEntity;
import com.clinica.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @PostMapping("/crear")
    public String crearTurno(@RequestBody LocalDate fecha,
                             @RequestBody String tratamiento,
                             @RequestBody String dniPaciente){

        turnoService.saveTurno(fecha, tratamiento, dniPaciente);

        return "Turno creado correctamente";
    }

    @GetMapping("/traer")
    public List<TurnoEntity> traerTurnos(){
        return turnoService.getTurnos();
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoService.deleteTurno(id);

        return "El turno fue eliminado correctamente";
    }

    @PutMapping("/editar/{id_original}")
    public TurnoEntity editTurno(@PathVariable Long id_original,
                                 @RequestBody TurnoEntity turnoEditar){
        turnoService.editTurno(id_original, turnoEditar);
        TurnoEntity turnoEditado = turnoService.findTurno(id_original);

        return turnoEditado;
    }

    @GetMapping("/traer/{id}")
    public TurnoEntity traerTurno(@PathVariable Long id){
        return turnoService.findTurno(id);
    }
}
