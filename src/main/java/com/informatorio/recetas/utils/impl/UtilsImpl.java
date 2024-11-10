package com.informatorio.recetas.utils.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.informatorio.recetas.domain.Step;
import com.informatorio.recetas.utils.UtilsInterface;

@Service
public class UtilsImpl implements UtilsInterface{

	@Override
	public int calcularTiempoNecesario(List<Step> lista) {
		int tiempo=0;
		for(Step step : lista) {
			if(step.isEsNecesario()) {
				tiempo = tiempo + step.getTiempoEstimado();
			}
		}
		return tiempo;
	}

}
