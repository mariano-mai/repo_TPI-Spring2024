package com.informatorio.recetas.dto.receta;

import java.util.List;
import java.util.UUID;

import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.paso.StepDetailDto;
import com.informatorio.recetas.enumerator.DificultadEnum;

public record RecipeGetByIdDto(
		UUID id, 
		String nombre, 
		DificultadEnum dificultad, 
		String descripcion, 
		CategoryCreatedDto categoria,
		List<StepDetailDto> pasos) {

}
