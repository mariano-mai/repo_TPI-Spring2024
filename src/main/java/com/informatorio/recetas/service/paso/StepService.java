package com.informatorio.recetas.service.paso;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepDetailDto;
import com.informatorio.recetas.dto.paso.StepIngredientUpdatedDto;
import com.informatorio.recetas.dto.paso.StepUpdateDto;

public interface StepService {
	
	Optional<StepCreatedDto> createStep(StepCreateDto stepCreateDto);
	
	Optional<StepIngredientUpdatedDto> addIngredient(UUID id, List<IngredienteCreateDto> ingredientesCreateDto);
	
	Optional<StepDetailDto> getStepById(UUID id);
	
	Optional<StepCreatedDto> updateStep(UUID id, StepUpdateDto stepUpdateDto);

}
