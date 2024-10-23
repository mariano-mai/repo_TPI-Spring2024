package com.informatorio.recetas.controller.paso;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.recetas.dto.paso.StepCreateDto;
import com.informatorio.recetas.dto.paso.StepCreatedDto;
import com.informatorio.recetas.service.paso.StepService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PasoController {
	
	private StepService stepService;
	
	@PostMapping("/api/v1/step")
	public ResponseEntity<?> createStep(@RequestBody StepCreateDto stepCreateDto){
		Optional<StepCreatedDto> stepCreatedDto = stepService.createStep(stepCreateDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(stepCreatedDto.get());
	}

}