package com.informatorio.recetas.service.categoria;

import java.util.Optional;

import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;

public interface CategoriaService {
	
	Optional<CategoryCreatedDto> createCategory(CategoryCreateDto categoryCreateDto);

}
