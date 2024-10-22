package com.informatorio.recetas.repository.categoria;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.recetas.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>{

}
