package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

import com.informatorio.recetas.dto.ingrediente.IngredienteDto;

public record StepDetailDto(
		UUID id,
		int tiempoEstimado,
		List<IngredienteDto> ingredientes) {

}
