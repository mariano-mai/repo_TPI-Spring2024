package com.informatorio.recetas.mapper.ingrediente;

import com.informatorio.recetas.domain.Ingredient;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreatedDto;
import com.informatorio.recetas.dto.ingrediente.IngredienteDto;

public interface IngredientMapper {
	
	Ingredient ingredienteCreateDtoToIngrediente(IngredienteCreateDto ingredienteCreateDto);
	
	IngredienteCreatedDto ingredienteToIngredientCreatedDto(Ingredient ingredient);
	
	IngredienteDto ingredienteToIngredienteDto(Ingredient ingrediente);

}
