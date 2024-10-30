package com.informatorio.recetas.mapper.paso;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepDetailDto;
import com.informatorio.recetas.dto.paso.StepIngredientUpdatedDto;

public interface StepMapper {
	
	Step stepCreateDtoToStep(StepCreateDto stepCreateDto);
	
	StepCreatedDto stepToStepCreatedDto(Step step);
	
	StepIngredientUpdatedDto stepToStepIngredientUpdatedDto(Step step);
	
	StepDetailDto stepToStepDetailDto(Step step);

}
