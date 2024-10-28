package com.informatorio.recetas.service.paso.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepIngredientUpdatedDto;
import com.informatorio.recetas.mapper.ingrediente.IngredientMapper;
import com.informatorio.recetas.mapper.paso.StepMapper;
import com.informatorio.recetas.repository.ingrediente.IngredientRepository;
import com.informatorio.recetas.repository.paso.StepRepository;
import com.informatorio.recetas.service.paso.StepService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StepServiceImpl implements StepService{
	
	private StepMapper stepMapper;
	private StepRepository stepRepository;
	private IngredientRepository ingredientRepository;
	private IngredientMapper ingredientMapper;
	
	@Override
	public Optional<StepCreatedDto> createStep(StepCreateDto stepCreateDto) {
		Step newStep = stepMapper.stepCreateDtoToStep(stepCreateDto);
		return Optional.of(stepMapper.stepToStepCreatedDto(stepRepository.save(newStep)));
	}

	@Override
	public Optional<StepIngredientUpdatedDto> addIngredient(UUID id, List<IngredienteCreateDto> ingredientesCreateDto) {
		Step step = stepRepository.getReferenceById(id);
		ingredientesCreateDto.stream().forEach(ingredienteDto -> step.getIngredientes()
				.add(ingredientRepository.save(ingredientMapper.ingredienteCreateDtoToIngrediente(ingredienteDto))));
		//step.getIngredientes().add(ingredientRepository.getReferenceById(idIngrediente));
		return Optional.of(stepMapper.stepToStepIngredientUpdatedDto(stepRepository.save(step)));
	}

}
