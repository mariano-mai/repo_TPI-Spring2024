package com.informatorio.recetas.mapper.paso.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Ingredient;
import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepIngredientUpdatedDto;
import com.informatorio.recetas.mapper.paso.StepMapper;
import com.informatorio.recetas.repository.ingrediente.IngredientRepository;
import com.informatorio.recetas.repository.receta.RecipeRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StepMapperImpl implements StepMapper{
	
	private RecipeRepository recipeRepository;
	private IngredientRepository ingredientRepository;

	@Override
	public Step stepCreateDtoToStep(StepCreateDto stepCreateDto) {
		Step newStep = new Step();
		newStep.setReceta(recipeRepository.getReferenceById(stepCreateDto.idReceta()));
		newStep.setDescripcion(stepCreateDto.descripcion());
		newStep.setTiempoEstimado(stepCreateDto.tiempoEstimado());
		/*stepCreateDto.ingredientes().stream()
			.forEach(ingrediente -> newStep.getIngredientes().add(ingredientRepository.getReferenceById(ingrediente)));*/
		newStep.setEsNecesario(stepCreateDto.esNecesario());
		return newStep;
	}

	@Override
	public StepCreatedDto stepToStepCreatedDto(Step step) {
		return new StepCreatedDto(
				step.getId(),
				step.getDescripcion(),
				//agregarIngredientes(step.getIngredientes()),
				step.getReceta().getId(),
				step.getReceta().getNombre(),
				step.getTiempoEstimado(),
				step.isEsNecesario());
	}
	
	private List<Long> agregarIngredientes(List<Ingredient> lista){
		List<Long> ingredientes = new ArrayList<>();
		lista.stream().forEach(ingrediente -> ingredientes.add(ingrediente.getId()));
		return ingredientes;
	}

	@Override
	public StepIngredientUpdatedDto stepToStepIngredientUpdatedDto(Step step) {
		return new StepIngredientUpdatedDto(
				step.getId(), 
				agregarNombresDeIngredientes(step.getIngredientes()));
	}
	
	private List<String> agregarNombresDeIngredientes(List<Ingredient> lista){
		List<String> ingredientes = new ArrayList<>();
		lista.stream().forEach(ingrediente -> ingredientes.add(ingrediente.getNombre()));
		return ingredientes;
	}

}
