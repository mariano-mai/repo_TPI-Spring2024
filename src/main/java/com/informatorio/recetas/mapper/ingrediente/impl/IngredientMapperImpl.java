package com.informatorio.recetas.mapper.ingrediente.impl;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Ingredient;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteDto;
import com.informatorio.recetas.mapper.ingrediente.IngredientMapper;

@Component
public class IngredientMapperImpl implements IngredientMapper{

	@Override
	public Ingredient ingredienteCreateDtoToIngrediente(IngredienteCreateDto ingredienteCreateDto) {
		Ingredient newIngrediente = new Ingredient();
		newIngrediente.setNombre(ingredienteCreateDto.nombre());
		newIngrediente.setDescripcion(ingredienteCreateDto.descripcion());
		return newIngrediente;
	}

	@Override
	public IngredienteCreatedDto ingredienteToIngredientCreatedDto(Ingredient ingredient) {
		return new IngredienteCreatedDto(
				ingredient.getId(),
				ingredient.getNombre(),
				ingredient.getDescripcion());
	}

	@Override
	public IngredienteDto ingredienteToIngredienteDto(Ingredient ingrediente) {
		return new IngredienteDto(
				ingrediente.getId(),
				ingrediente.getNombre());
	}

}
