package com.informatorio.recetas.domain;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
	
	@Id
	@GeneratedValue
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length=30, columnDefinition="varchar(36)", updatable=false, nullable=false)
	private int id;
	
	@Column(length=50, nullable=false, unique=true)
	private String nombre;
	
	@Column(length=1000)
	private String descripcion;

}
