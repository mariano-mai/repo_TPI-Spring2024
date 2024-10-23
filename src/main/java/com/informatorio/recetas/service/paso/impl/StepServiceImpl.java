package com.informatorio.recetas.service.paso.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.mapper.paso.StepMapper;
import com.informatorio.recetas.repository.paso.StepRepository;
import com.informatorio.recetas.service.paso.StepService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StepServiceImpl implements StepService{
	
	private StepMapper stepMapper;
	private StepRepository stepRepository;
	
	@Override
	public Optional<StepCreatedDto> createStep(StepCreateDto stepCreateDto) {
		Step newStep = stepMapper.stepCreateDtoToStep(stepCreateDto);
		return Optional.of(stepMapper.stepToStepCreatedDto(stepRepository.save(newStep)));
	}

}
