package com.example.demo.servicios.dto.anime;

import com.example.demo.servicios.dto.genero.GeneroDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimeDTO {
	long id;
	
	String nombreAnime;
	
	String estudioAnimacion;
	
	String fechaEmision;
	
	String fechaFinalizacion;
	
	int numeroCapitulos;
	
    private GeneroDTO genero;

	public AnimeDTO() {
		super();
	}

	public AnimeDTO(String nombreAnime, String estudioAnimacion, String fechaEmision,
			String fechaFinalizacion, int numeroCapitulos, GeneroDTO genero) {
		this.nombreAnime = nombreAnime;
		this.estudioAnimacion = estudioAnimacion;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}

	public AnimeDTO(long id, String nombreAnime, String estudioAnimacion, String fechaEmision,
			String fechaFinalizacion, int numeroCapitulos, GeneroDTO genero) {
		this.id = id;
		this.nombreAnime = nombreAnime;
		this.estudioAnimacion = estudioAnimacion;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}
	
	
	
}
