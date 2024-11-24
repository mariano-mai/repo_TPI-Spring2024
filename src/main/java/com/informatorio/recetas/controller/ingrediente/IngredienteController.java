package com.informatorio.recetas.controller.ingrediente;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.informatorio.recetas.service.ingrediente.IngredientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class IngredienteController {
	
	IngredientService ingredientService;
	
	@PostMapping("/api/v1/ingredient")
	public ResponseEntity<?> createIngredient(@RequestBody IngredienteCreateDto ingredienteCreateDto){
		Optional<IngredienteCreatedDto> ingredientCreatedDto = ingredientService.createIngredient(ingredienteCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ingredientCreatedDto.get());
	}
	
	@DeleteMapping("/api/v1/ingredient/{idIngredient}")
	public ResponseEntity<?> deleteIngredient(
			@PathVariable(value="idIngredient") Long idIngredient){
		boolean isIngredientDeleted = ingredientService.deleteIngredient(idIngredient);
		if(isIngredientDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
