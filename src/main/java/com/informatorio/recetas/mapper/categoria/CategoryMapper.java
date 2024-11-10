package com.informatorio.recetas.mapper.categoria;

import com.informatorio.recetas.domain.Category;
import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.categoria.CategoryDto;

public interface CategoryMapper {
	
	Category categoriaCreateDtoToCategoria(CategoryCreateDto categoryCreateDto);
	
	CategoryCreatedDto categoriaToCategoriaCreatedDto(Category category);
	
	CategoryDto categoriaToCategoriaDto(Category category);

}
