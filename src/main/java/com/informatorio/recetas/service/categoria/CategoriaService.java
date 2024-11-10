package com.informatorio.recetas.service.categoria;

import java.util.Optional;
import java.util.UUID;

import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.categoria.CategoryDto;

public interface CategoriaService {
	
	Optional<CategoryCreatedDto> createCategory(CategoryCreateDto categoryCreateDto);
	
	void addRecipe(UUID idReceta, UUID idCategoria);
	
	Optional<CategoryDto> getCategoryById(UUID id);
	
}
