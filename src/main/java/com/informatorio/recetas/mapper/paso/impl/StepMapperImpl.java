package com.informatorio.recetas.mapper.paso.impl;

import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.mapper.paso.StepMapper;

@Component
public class StepMapperImpl implements StepMapper{

	@Override
	public Step stepCreateDtoToStep(StepCreateDto stepCreateDto) {
		Step newStep = new Step();
		newStep.setDescripcion(stepCreateDto.descripcion());
		newStep.setTiempoEstimado(stepCreateDto.tiempoEstimado());
		newStep.setEsNecesario(stepCreateDto.esNecesario());
		return newStep;
	}

	@Override
	public StepCreatedDto stepToStepCreatedDto(Step step) {
		return new StepCreatedDto(
				step.getId(),
				step.getDescripcion(),
				step.getTiempoEstimado(),
				step.isEsNecesario());
	}

}
