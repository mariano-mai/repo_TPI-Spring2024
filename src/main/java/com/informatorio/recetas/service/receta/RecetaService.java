package com.informatorio.recetas.service.receta;

import java.util.Optional;
import java.util.UUID;

import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.dto.receta.RecipeGetByIdDto;

public interface RecetaService {
	
	Optional<RecipeCreatedDto> createRecipe(RecipeCreateDto recipeCreateDto);
	
	Optional<RecipeCategoryUpdatedDto> addCategory(UUID idReceta, UUID idCategoria);
	
	Optional<RecipeGetByIdDto> getRecetaById(UUID id);
	
	boolean deleteRecipe(UUID id);

}
