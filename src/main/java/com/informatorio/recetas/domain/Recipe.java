package com.informatorio.recetas.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.informatorio.recetas.enumerator.DificultadEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Recipe {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@SuppressWarnings("deprecation")
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length=30, columnDefinition="varchar(36)", updatable=false, nullable=false)
	private UUID id;
	
	@Column(nullable=false, unique=true)
	private String nombre;
	
	
	private List<Step> pasos;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private DificultadEnum dificultad;
	
	@Column(length=5000, nullable=false)
	private String descripcion;
	
	
	private Category categoria;

}
