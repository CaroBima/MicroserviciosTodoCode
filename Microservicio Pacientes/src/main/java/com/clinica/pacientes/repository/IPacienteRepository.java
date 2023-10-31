package com.clinica.pacientes.repository;

import com.clinica.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query(value = "SELECT * FROM paciente pac WHERE pac.dni = :dni", nativeQuery = true)
    Paciente findByDni(@Param("dni") String dni);

}
