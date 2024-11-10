package com.informatorio.recetas.alternative.receta;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeByCategoryDto;

public interface RecipeAlternative {
	
	RecipeByCategoryDto recetaToRecetaByCategoriaDto(Recipe recipe);

}
