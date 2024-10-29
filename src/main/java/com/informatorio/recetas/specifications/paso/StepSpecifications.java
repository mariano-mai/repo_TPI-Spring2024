package com.informatorio.recetas.specifications.paso;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Ingredient;
import com.informatorio.recetas.domain.Step;

import jakarta.persistence.criteria.Join;

@Component
public class StepSpecifications {
	
	public static Specification<Step> hasNameLike(String nombre){
		return (root, query, CriteriaBuilder) -> CriteriaBuilder.like(root.<String>get("nombre"), nombre);
	}
	
	public static Specification<Step> hasIdLike(UUID idStep){
		return(root, query, CriteriaBuilder) -> CriteriaBuilder.equal(root.<UUID>get("idStep"), idStep);
	}
	
	public static Specification<Step> hasIngredientWithName(String ingredientName){
		return(root, query, CriteriaBuilder) ->{
			Join<Ingredient, Step> stepIngredient = root.join("ingredientes");
			return CriteriaBuilder.equal(stepIngredient.get("nombre"), ingredientName);
		};
	}

}
