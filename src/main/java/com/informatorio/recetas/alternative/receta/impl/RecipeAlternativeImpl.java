package com.informatorio.recetas.alternative.receta.impl;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.alternative.receta.RecipeAlternative;
import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeByCategoryDto;
import com.informatorio.recetas.utils.UtilsInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeAlternativeImpl implements RecipeAlternative{
	
	private UtilsInterface utilsInterface;

	@Override
	public RecipeByCategoryDto recetaToRecetaByCategoriaDto(Recipe recipe) {
		return new RecipeByCategoryDto(
				recipe.getId(),
				recipe.getNombre(),
				recipe.getDificultad(),
				recipe.getDescripcion(),
				utilsInterface.calcularTiempoNecesario(recipe.getPasos()));
	}

}
