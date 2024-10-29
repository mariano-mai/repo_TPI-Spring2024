package com.informatorio.recetas.controller.receta;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.receta.RecipeCategoryUpdateDto;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
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
	
	@PutMapping("/api/v1/recipe/{idReceta}")
	public ResponseEntity<?> updateCategoryOfRecipe(
			@PathVariable(value="idReceta") UUID id,
			@RequestBody RecipeCategoryUpdateDto recipeCategoryUpdateDto){
		Optional<RecipeCategoryUpdatedDto> recipeUpdated = recipeService.addCategory(id, recipeCategoryUpdateDto.idCategoria());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(recipeUpdated.get());
	}
	
	@GetMapping("/api/v1/recipe/{idReceta}")
	public ResponseEntity<?> getRecipeById(
			@PathVariable(value="idReceta") UUID id){
		Optional<RecipeCreatedDto> recipeCreatedDto = recipeService.getRecetaById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(recipeCreatedDto.get());
	}

}
