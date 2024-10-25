package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

public record StepCreatedDto(
		UUID id, 
		String descripcion, 
		//List<Long> ingredientes, 
		UUID receta, 
		String nombreReceta,
		int tiempoEstimado, 
		boolean esNecesario) {

}
