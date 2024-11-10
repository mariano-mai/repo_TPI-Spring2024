package com.informatorio.recetas.service.receta.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.dto.receta.RecipeGetByIdDto;
import com.informatorio.recetas.mapper.receta.RecipeMapper;
import com.informatorio.recetas.repository.categoria.CategoryRepository;
import com.informatorio.recetas.repository.receta.RecipeRepository;
import com.informatorio.recetas.service.categoria.CategoriaService;
import com.informatorio.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecetaServiceImpl implements RecetaService{
	
	private RecipeMapper recipeMapper;
	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private CategoriaService categoryService;
	
	@Override
	public Optional<RecipeCreatedDto> createRecipe(RecipeCreateDto recipeCreateDto) {
		Recipe newRecipe = recipeMapper.recetaCreateDtoToReceta(recipeCreateDto);
		return Optional.of(recipeMapper.recetaToRecetaCreatedDto(recipeRepository.save(newRecipe)));
	}

	@Override
	public Optional<RecipeCategoryUpdatedDto> addCategory(UUID idReceta, UUID idCategoria) {
		Recipe receta = recipeRepository.getReferenceById(idReceta);
		receta.setCategoria(categoryRepository.getReferenceById(idCategoria));
		categoryService.addRecipe(idReceta, idCategoria);
		return Optional.of(recipeMapper.recetaToRecetaCategoriaUpdatedDto(recipeRepository.save(receta)));
	}

	@Override
	public Optional<RecipeGetByIdDto> getRecetaById(UUID id) {
		Recipe receta = recipeRepository.getReferenceById(id);
		return Optional.of(recipeMapper.recetaToRecetaGetByIdDto(receta));
	}

}
