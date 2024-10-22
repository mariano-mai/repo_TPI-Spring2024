package com.informatorio.recetas.mapper.receta;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;

public interface RecipeMapper {
	
	Recipe recetaCreateDtoToReceta(RecipeCreateDto recipeCreateDto);
	
	RecipeCreatedDto recetaToRecetaCreatedDto(Recipe recipe);

}
