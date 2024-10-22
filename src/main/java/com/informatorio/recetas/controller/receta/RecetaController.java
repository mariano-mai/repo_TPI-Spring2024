package com.informatorio.recetas.controller.receta;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RecetaController {
	
	private RecetaService recipeService;
	
	@PostMapping("/api/v1/recipe")
	public ResponseEntity<?> createRecipe(@RequestBody RecipeCreateDto recipeCreateDto){
		Optional<RecipeCreatedDto> recipeCreatedDto = recipeService.createRecipe(recipeCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(recipeCreatedDto.get());
	}

}
