package com.example.demo.servicios.dto.pelicula;

import com.example.demo.servicios.dto.genero.GeneroDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaDTO {

	long id;

	String nombrePelicula;

	String director;

	String fechaEmision;

	float duracion;

	private GeneroDTO genero;

	public PeliculaDTO() {
		super();
	}

	// pelicula insertada

	public PeliculaDTO(String nombrePelicula, String director, String fechaEmision, float duracion, GeneroDTO genero) {
		this.nombrePelicula = nombrePelicula;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
		this.genero = genero;
	}

	// pelicula modificada

	public PeliculaDTO(long id, String nombrePelicula, String director, String fechaEmision, float duracion,
			GeneroDTO genero) {
		this.id = id;
		this.nombrePelicula = nombrePelicula;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
		this.genero = genero;
	}

}
