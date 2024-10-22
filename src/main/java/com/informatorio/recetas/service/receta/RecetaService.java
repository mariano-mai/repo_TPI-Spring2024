package com.informatorio.recetas.service.receta;

import java.util.Optional;

import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;

public interface RecetaService {
	
	Optional<RecipeCreatedDto> createRecipe(RecipeCreateDto recipeCreateDto);

}
