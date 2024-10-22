package com.informatorio.recetas.dto.receta;

import java.util.UUID;

import com.informatorio.recetas.enumerator.DificultadEnum;

public record RecipeCreatedDto(UUID id, String nombre, DificultadEnum dificultad, String descripcion) {

}
