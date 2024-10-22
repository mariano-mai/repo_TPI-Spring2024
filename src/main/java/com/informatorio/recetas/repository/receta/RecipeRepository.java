package com.informatorio.recetas.repository.receta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.recetas.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, UUID>{

}
