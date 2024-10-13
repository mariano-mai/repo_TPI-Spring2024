package com.informatorio.recetas.domain;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Category {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@SuppressWarnings("deprecation")
	@JdbcTypeCode(SqlTypes.CHAR)
	@Column(length=30, columnDefinition="varchar(36)", updatable=false, nullable=false)
	private UUID id;
	
	@Column(length=50, nullable=false, unique=true)
	private String nombre;
	
	@OneToMany(mappedBy="categoria", fetch=FetchType.LAZY)
	private List<Recipe> recetas;

}
