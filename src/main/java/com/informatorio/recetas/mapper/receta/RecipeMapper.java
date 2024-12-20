package com.informatorio.recetas.mapper.receta;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.dto.receta.RecipeGetByIdDto;

public interface RecipeMapper {
	
	Recipe recetaCreateDtoToReceta(RecipeCreateDto recipeCreateDto);
	
	RecipeCreatedDto recetaToRecetaCreatedDto(Recipe recipe);
	
	RecipeCategoryUpdatedDto recetaToRecetaCategoriaUpdatedDto(Recipe recipe);
	
	RecipeGetByIdDto recetaToRecetaGetByIdDto(Recipe recipe);

}
