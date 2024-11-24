package com.informatorio.recetas.dto.paso;

import java.util.List;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;

public record StepUpdateDto(
		String descripcion, 
		int tiempoEstimado,
		boolean esNecesario, 
		List<IngredienteCreateDto> ingredientes) {

}
