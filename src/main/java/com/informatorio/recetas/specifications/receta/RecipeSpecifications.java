package com.informatorio.recetas.specifications.receta;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.informatorio.recetas.domain.Recipe;
import com.informatorio.recetas.domain.Step;

import jakarta.persistence.criteria.Join;

@Component
public class RecipeSpecifications {
	
	public static Specification<Recipe> hasNameLike(String nombre){
		return(root, query, CriteriaBuilder) -> CriteriaBuilder.like(root.<String>get("nombre"), nombre);
	}
	
	public static Specification<Recipe> hasIdLike(UUID idRecipe){
		return(root, query, CriteriaBuilder) -> CriteriaBuilder.equal(root.<UUID>get("idRecipe"), idRecipe);
	}
	
	public static Specification<Recipe> hasStepWithId(UUID idStep){
		return(root, query, CriteriaBuilder) ->{
			Join<Step, Recipe> stepIngredient = root.join("pasos");
			return CriteriaBuilder.equal(stepIngredient.get("id"), idStep);
		};
	}

}
