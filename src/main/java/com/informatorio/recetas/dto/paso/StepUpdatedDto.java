package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;

public record StepUpdatedDto(
		UUID idReceta, 
		String descripcion, 
		int tiempoEstimado, 
		boolean esNecesario, 
		List<IngredienteCreatedDto> ingredientes) {

}
