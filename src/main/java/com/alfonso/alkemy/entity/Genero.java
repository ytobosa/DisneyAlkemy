package com.alfonso.alkemy.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = "genero")
public class Genero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7855363905178659769L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String imagen;

	@OneToMany
	List<PeliculaSerie> peliculas;
	
}
