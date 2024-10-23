package com.informatorio.recetas.dto.receta;

import java.util.UUID;

import com.informatorio.recetas.enumerator.DificultadEnum;

public record RecipeCategoryUpdatedDto(
		UUID id, 
		String nombre, 
		DificultadEnum dificultad, 
		String descripcion, 
		UUID idCategoria) {

}
