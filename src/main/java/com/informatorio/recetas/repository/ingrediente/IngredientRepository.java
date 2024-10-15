package com.informatorio.recetas.repository.ingrediente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.recetas.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
