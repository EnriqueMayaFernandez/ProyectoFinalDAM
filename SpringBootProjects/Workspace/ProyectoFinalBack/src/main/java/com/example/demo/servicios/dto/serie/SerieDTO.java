package com.example.demo.servicios.dto.serie;

import com.example.demo.servicios.dto.genero.GeneroDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerieDTO {

	long id;

	String nombreSerie;

	String director;

	String fechaEmision;

	String fechaFinalizacion;

	int numeroCapitulos;
	
	private GeneroDTO genero;
	

	public SerieDTO() {
		super();
	}

	public SerieDTO(String nombreSerie, String rutaImagenSerie, String director, String fechaEmision,
			String fechaFinalizacion, int numeroCapitulos, GeneroDTO genero) {
		this.nombreSerie = nombreSerie;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}

	public SerieDTO(long id, String nombreSerie, String director, String fechaEmision, String fechaFinalizacion,
			int numeroCapitulos, GeneroDTO genero) {
		this.id = id;
		this.nombreSerie = nombreSerie;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}
	
	
	
}
