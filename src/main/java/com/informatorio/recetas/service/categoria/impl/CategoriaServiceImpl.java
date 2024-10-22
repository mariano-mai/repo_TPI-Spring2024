package com.informatorio.recetas.service.categoria.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Category;
import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.mapper.categoria.CategoryMapper;
import com.informatorio.recetas.repository.categoria.CategoryRepository;
import com.informatorio.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoryMapper categoryMapper;
	private CategoryRepository categoryRepository;
	
	@Override
	public Optional<CategoryCreatedDto> createCategory(CategoryCreateDto categoryCreateDto) {
		Category newCategory = categoryMapper.categoriaCreateDtoToCategoria(categoryCreateDto);
		return Optional.of(categoryMapper.categoriaToCategoriaCreatedDto(categoryRepository.save(newCategory)));
	}

}
