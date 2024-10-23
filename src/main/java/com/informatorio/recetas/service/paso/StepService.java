package com.informatorio.recetas.service.paso;

import java.util.Optional;

import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;

public interface StepService {
	
	Optional<StepCreatedDto> createStep(StepCreateDto stepCreateDto);

}
