package com.informatorio.recetas.controller.categoria;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.categoria.CategoryCreateDto;
import com.informatorio.recetas.dto.categoria.CategoryCreatedDto;
import com.informatorio.recetas.dto.categoria.CategoryDto;
import com.informatorio.recetas.service.categoria.CategoriaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@PostMapping("/api/v1/category")
	public ResponseEntity<?> createCategory(@RequestBody CategoryCreateDto categoryCreateDto){
		Optional<CategoryCreatedDto> categoryCreatedDto = categoriaService.createCategory(categoryCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(categoryCreatedDto.get());
	}
	
	@GetMapping("/api/v1/category/{idCategoria}")
	public ResponseEntity<?> getCategoryById(
			@PathVariable(value="idCategoria") UUID id){
		Optional<CategoryDto> categoryDto = categoriaService.getCategoryById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(categoryDto.get());
	}

}
