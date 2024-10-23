package com.informatorio.recetas.mapper.receta.impl;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.mapper.receta.RecipeMapper;

@Component
public class RecipeMapperImpl implements RecipeMapper{

	@Override
	public Recipe recetaCreateDtoToReceta(RecipeCreateDto recipeCreateDto) {
		Recipe newRecipe = new Recipe();
		newRecipe.setId(UUID.randomUUID());
		newRecipe.setNombre(recipeCreateDto.nombre());
		newRecipe.setDificultad(recipeCreateDto.dificultad());
		newRecipe.setDescripcion(recipeCreateDto.descripcion());
		return newRecipe;
	}

	@Override
	public RecipeCreatedDto recetaToRecetaCreatedDto(Recipe recipe) {
		return new RecipeCreatedDto(
				recipe.getId(),
				recipe.getNombre(),
				recipe.getDificultad(),
				recipe.getDescripcion());
	}

	@Override
	public RecipeCategoryUpdatedDto recetaToRecetaCategoriaUpdatedDto(Recipe recipe) {
		return new RecipeCategoryUpdatedDto(
				recipe.getId(),
				recipe.getNombre(),
				recipe.getDificultad(),
				recipe.getDescripcion(),
				recipe.getCategoria().getId());
	}

}
