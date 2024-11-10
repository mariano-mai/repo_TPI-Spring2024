package com.informatorio.recetas.service.categoria.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Category;
import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.categoria.CategoryDto;
import com.informatorio.recetas.mapper.categoria.CategoryMapper;
import com.informatorio.recetas.repository.categoria.CategoryRepository;
import com.informatorio.recetas.repository.receta.RecipeRepository;
import com.informatorio.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoryMapper categoryMapper;
	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;
	
	@Override
	public Optional<CategoryCreatedDto> createCategory(CategoryCreateDto categoryCreateDto) {
		Category newCategory = categoryMapper.categoriaCreateDtoToCategoria(categoryCreateDto);
		return Optional.of(categoryMapper.categoriaToCategoriaCreatedDto(categoryRepository.save(newCategory)));
	}

	@Override
	public void addRecipe(UUID idReceta, UUID idCategoria) {
		Category category = categoryRepository.getReferenceById(idCategoria);
		category.getRecetas().add(recipeRepository.getReferenceById(idReceta));
		
	}

	@Override
	public Optional<CategoryDto> getCategoryById(UUID id) {
		Category category = categoryRepository.getReferenceById(id);
		return Optional.of(categoryMapper.categoriaToCategoriaDto(category));
	}

}
