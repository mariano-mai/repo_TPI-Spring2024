package com.informatorio.recetas.dto.categoria;

import java.util.List;

import com.informatorio.recetas.dto.receta.RecipeByCategoryDto;

public record CategoryDto(
		String nombre,
		List<RecipeByCategoryDto> recetas
		) {

}
