package com.informatorio.recetas.dto.paso;

import java.util.List;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;

public record StepIngredientUpdateDto(
		List<IngredienteCreateDto> ingredientesDto) {

}
