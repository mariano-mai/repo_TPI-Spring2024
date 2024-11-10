package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;


public record StepCreateDto(
		UUID idReceta, 
		String descripcion, 
		int tiempoEstimado, 
		boolean esNecesario,
		List<IngredienteCreateDto> ingredientes) {

}
