package com.jvtavares.horariosescolares.repository;

import com.jvtavares.horariosescolares.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
