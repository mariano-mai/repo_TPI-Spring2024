package com.informatorio.recetas.repository.paso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.informatorio.recetas.domain.Step;

public interface StepRepository extends JpaRepository<Step, UUID>, JpaSpecificationExecutor<Step>{

}
