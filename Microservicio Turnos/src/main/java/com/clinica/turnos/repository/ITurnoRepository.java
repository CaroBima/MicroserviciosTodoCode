package com.clinica.turnos.repository;

import com.clinica.turnos.model.TurnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<TurnoEntity, Long> {
}
