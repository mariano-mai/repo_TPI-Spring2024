package com.informatorio.recetas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Step {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@SuppressWarnings("deprecation")
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length=30, columnDefinition="varchar(36)", updatable=false, nullable=false)
	private UUID id;
	
	@ManyToOne
	private Recipe receta;
	
	@Column(length=5000, nullable=false)
	private String descripcion;
	
	@Column
	private int tiempoEstimado;
	
	@Column
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="ingrediente_paso",
			joinColumns=
				@JoinColumn(name="step_id", referencedColumnName ="id"),
			inverseJoinColumns=
				@JoinColumn(name="ingredient_id", referencedColumnName="id"))
	//@JoinColumn(name="ingrediente_id")
	private List<Ingredient> ingredientes = new ArrayList<>();
	
	@Column
	private boolean esNecesario;

}
