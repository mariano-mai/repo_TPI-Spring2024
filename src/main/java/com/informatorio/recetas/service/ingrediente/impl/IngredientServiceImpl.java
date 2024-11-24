package com.informatorio.recetas.service.ingrediente.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Ingredient;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.informatorio.recetas.mapper.ingrediente.IngredientMapper;
import com.informatorio.recetas.repository.ingrediente.IngredientRepository;
import com.informatorio.recetas.service.ingrediente.IngredientService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService{
	
	private IngredientMapper ingredientMapper;
	private IngredientRepository ingredientRepository;

	@Override
	public Optional<IngredienteCreatedDto> createIngredient(IngredienteCreateDto ingredienteCreateDto) {
		Ingredient newIngredient = ingredientMapper.ingredienteCreateDtoToIngrediente(ingredienteCreateDto);
		return Optional.of(ingredientMapper.ingredienteToIngredientCreatedDto(ingredientRepository.save(newIngredient)));
	}

	@Override
	public boolean deleteIngredient(Long id) {
		Optional<Ingredient> ingredient = Optional.of(ingredientRepository.getReferenceById(id));
		if(ingredient.isPresent()) {
			ingredientRepository.delete(ingredientRepository.getReferenceById(id));
			return true;
		}
		return false;
	}

}
