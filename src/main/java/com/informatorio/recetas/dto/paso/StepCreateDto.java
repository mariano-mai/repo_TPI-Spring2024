package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;


public record StepCreateDto(
		UUID idReceta, 
		String descripcion, 
		int tiempoEstimado, 
		//List<Long> ingredientes, 
		boolean esNecesario) {

}
