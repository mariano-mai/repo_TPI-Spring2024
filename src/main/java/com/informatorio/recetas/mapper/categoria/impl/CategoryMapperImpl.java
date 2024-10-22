package com.informatorio.recetas.mapper.categoria.impl;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Category;
import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.mapper.categoria.CategoryMapper;

@Component
public class CategoryMapperImpl implements CategoryMapper{

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

}
