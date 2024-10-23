package com.informatorio.recetas.repository.paso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.recetas.domain.Step;

public interface StepRepository extends JpaRepository<Step, UUID>{

}
