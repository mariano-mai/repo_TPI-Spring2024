package com.informatorio.recetas.service.paso.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.ingrediente.IngredienteCreateDto;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.dto.paso.StepDetailDto;
import com.informatorio.recetas.dto.paso.StepIngredientUpdatedDto;
import com.informatorio.recetas.dto.paso.StepUpdateDto;
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

	@Override
	public Optional<StepDetailDto> getStepById(UUID id) {
		Step step = stepRepository.getReferenceById(id);
		return Optional.of(stepMapper.stepToStepDetailDto(step));
	}

	@Override
	public Optional<StepCreatedDto> updateStep(UUID id, StepUpdateDto stepUpdateDto) {
		Step step = stepRepository.getReferenceById(id);
		cleanIngredients(step);
		updateStepContent(step, stepUpdateDto);
		return Optional.of(stepMapper.stepToStepCreatedDto(step));
	}
	
	private void cleanIngredients(Step step) {
		step.getIngredientes().stream().forEach(ingredient -> ingredientRepository.delete(ingredient));
	}
	
	private void updateStepContent(Step step, StepUpdateDto stepUpdateDto) {
		step.setDescripcion(stepUpdateDto.descripcion());
		step.setTiempoEstimado(stepUpdateDto.tiempoEstimado());
		step.setEsNecesario(stepUpdateDto.esNecesario());
		stepUpdateDto.ingredientes().stream().forEach(
				ingrediente -> step.getIngredientes().add(ingredientMapper.ingredienteCreateDtoToIngrediente(ingrediente)));
	}

}
