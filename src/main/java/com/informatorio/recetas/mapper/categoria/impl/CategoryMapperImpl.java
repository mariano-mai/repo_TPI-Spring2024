package com.informatorio.recetas.mapper.categoria.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.alternative.receta.RecipeAlternative;
import com.informatorio.recetas.domain.Category;
import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.categoria.CategoryDto;
import com.informatorio.recetas.dto.receta.RecipeByCategoryDto;
import com.informatorio.recetas.mapper.categoria.CategoryMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryMapperImpl implements CategoryMapper{
	
	private RecipeAlternative recipeAlternative;

	@Override
	public Category categoriaCreateDtoToCategoria(CategoryCreateDto categoryCreateDto) {
		Category newCategory = new Category();
		newCategory.setId(UUID.randomUUID());
		newCategory.setNombre(categoryCreateDto.nombre());
		return newCategory;
	}

	@Override
	public CategoryCreatedDto categoriaToCategoriaCreatedDto(Category category) {
		return new CategoryCreatedDto(
				category.getId(),
				category.getNombre());
	}

	@Override
	public CategoryDto categoriaToCategoriaDto(Category category) {
		return new CategoryDto(
				category.getNombre(),
				agregarRecetasDto(category.getRecetas())
				);
	}
	
	private List<RecipeByCategoryDto> agregarRecetasDto(List<Recipe> lista){
		List<RecipeByCategoryDto> recetasDto = new ArrayList<>();
		lista.stream().forEach(recipe -> recetasDto.add(recipeAlternative.recetaToRecetaByCategoriaDto(recipe)));
		return recetasDto;
	}
	
}
