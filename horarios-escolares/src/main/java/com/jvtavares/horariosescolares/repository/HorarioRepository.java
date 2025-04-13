package com.jvtavares.horariosescolares.repository;

import com.jvtavares.horariosescolares.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
