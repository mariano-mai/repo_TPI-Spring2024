package com.informatorio.recetas.mapper.receta.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.paso.StepDetailDto;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.dto.receta.RecipeGetByIdDto;
import com.informatorio.recetas.mapper.categoria.CategoryMapper;
import com.informatorio.recetas.mapper.paso.StepMapper;
import com.informatorio.recetas.mapper.receta.RecipeMapper;
import com.informatorio.recetas.repository.categoria.CategoryRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecipeMapperImpl implements RecipeMapper{
	
	private CategoryMapper categoryMapper;
	private CategoryRepository categoryRepository;
	private StepMapper stepMapper;

	@Override
	public Recipe recetaCreateDtoToReceta(RecipeCreateDto recipeCreateDto) {
		Recipe newRecipe = new Recipe();
		newRecipe.setId(UUID.randomUUID());
		newRecipe.setNombre(recipeCreateDto.nombre());
		newRecipe.setDificultad(recipeCreateDto.dificultad());
		newRecipe.setDescripcion(recipeCreateDto.descripcion());
		newRecipe.setCategoria(categoryRepository.getReferenceById(recipeCreateDto.idCategoria()));
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

	@Override
	public RecipeGetByIdDto recetaToRecetaGetByIdDto(Recipe recipe) {
		return new RecipeGetByIdDto(
				recipe.getId(),
				recipe.getNombre(),
				recipe.getDificultad(),
				recipe.getDescripcion(),
				categoryMapper.categoriaToCategoriaCreatedDto(recipe.getCategoria()),
				agregarPasosDto(recipe.getPasos())
				);
	}
	
	private List<StepDetailDto> agregarPasosDto(List<Step> lista){
		List<StepDetailDto> pasosDto = new ArrayList<>();
		lista.stream().forEach(step -> pasosDto.add(stepMapper.stepToStepDetailDto(step)));
		return pasosDto;
	}

}
