package com.informatorio.recetas.dto.paso;

import java.util.List;
import java.util.UUID;

public record StepIngredientUpdatedDto(
		UUID id, 
		List<String> ingredientes) {

}
