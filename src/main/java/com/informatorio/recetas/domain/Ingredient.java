package com.informatorio.recetas.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Parameter;
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
	@GeneratedValue(generator="sequence-generator")
	@GenericGenerator(
			name="sequence-generator",
			strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters= {
					@Parameter(name="sequence_name", value="ingredient_sequence"),
					@Parameter(name="initial_value", value="1")
			}
				)
	@SuppressWarnings("deprecation")
	@JdbcTypeCode(SqlTypes.INTEGER)
	@Column(length=30, columnDefinition="varchar(36)", updatable=false, nullable=false)
	private Long id;
	
	@Column(length=50, nullable=false, unique=true)
	private String nombre;
	
	@Column(length=1000)
	private String descripcion;

}
