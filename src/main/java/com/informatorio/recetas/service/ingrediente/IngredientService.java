package com.informatorio.recetas.service.ingrediente;

import java.util.Optional;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;

public interface IngredientService {
	
	Optional<IngredienteCreatedDto> createIngredient(IngredienteCreateDto ingredienteCreateDto);

}
