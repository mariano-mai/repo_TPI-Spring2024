package com.informatorio.recetas.service.receta.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.mapper.receta.RecipeMapper;
import com.informatorio.recetas.repository.receta.RecipeRepository;
import com.informatorio.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService{
	
	private RecipeMapper recipeMapper;
	private RecipeRepository recipeRepository;
	
	@Override
	public Optional<RecipeCreatedDto> createRecipe(RecipeCreateDto recipeCreateDto) {
		Recipe newRecipe = recipeMapper.recetaCreateDtoToReceta(recipeCreateDto);
		return Optional.of(recipeMapper.recetaToRecetaCreatedDto(recipeRepository.save(newRecipe)));
	}
}
