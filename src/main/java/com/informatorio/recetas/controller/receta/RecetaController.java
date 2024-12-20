package com.informatorio.recetas.controller.receta;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepUpdateDto;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdateDto;
import com.informatorio.recetas.dto.receta.RecipeCategoryUpdatedDto;
import com.informatorio.recetas.dto.receta.RecipeCreateDto;
import com.informatorio.recetas.dto.receta.RecipeCreatedDto;
import com.informatorio.recetas.dto.receta.RecipeGetByIdDto;
import com.informatorio.recetas.service.paso.StepService;
import com.informatorio.recetas.service.receta.RecetaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RecetaController {
	
	private RecetaService recipeService;
	private StepService stepService;
	
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
	
	@PutMapping("/api/v1/recipe/")
	public ResponseEntity<?> updateStepOfRecipe(
			@RequestParam(name="idReceta") UUID idReceta,
			@RequestParam(name="idPaso") UUID idPaso,
			@RequestBody StepUpdateDto stepUpdateDto){
		Optional<StepCreatedDto> stepUpdated = stepService.updateStep(idPaso, stepUpdateDto);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(stepUpdated.get());
	}
	
	@GetMapping("/api/v1/recipe/{idReceta}")
	public ResponseEntity<?> getRecipeById(
			@PathVariable(value="idReceta") UUID id){
		Optional<RecipeGetByIdDto> recipeGetByIdDto = recipeService.getRecetaById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(recipeGetByIdDto.get());
	}
	
	@DeleteMapping("/api/v1/recipe/{idReceta}")
	public ResponseEntity<?> deleteRecipe(
			@PathVariable(value="idReceta") UUID idReceta){
		boolean isRecipeDeleted = recipeService.deleteRecipe(idReceta);
		if(isRecipeDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
