package com.example.demo.modelo;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PELICULA")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_PELICULA")
	String nombrePelicula;
	@Column(name = "DIRECTOR")
	String director;
	@Column(name = "FECHA_EMISION")
	Date fechaEmision;
	@Column(name = "DURACION")
	float duracion;
	@ManyToOne
	@JoinColumn(name="idGenero")
	private Genero genero;
	@OneToMany(mappedBy = "pelicula")
	private List<RelacionUsuarioPelicula> relacionUsuarioPelicula;
	
	public Pelicula() {
		super();
	}
	
	//pelicula insertada
	public Pelicula(String nombrePelicula, String director, Date fechaEmision,
			float duracion, Genero genero) {
		this.nombrePelicula = nombrePelicula;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
		this.genero = genero;
	}

	//pelicula modificada
	
	public Pelicula(long id, String nombrePelicula, String director, Date fechaEmision,
			float duracion, Genero genero) {
		this.id = id;
		this.nombrePelicula = nombrePelicula;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
		this.genero = genero;
	}


	
	

	
	
	

	
	

}
