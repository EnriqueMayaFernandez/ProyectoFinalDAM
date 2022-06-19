package com.example.demo.servicios.dto.pelicula;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoPeliculasDTO {
	List<PeliculaDTO> listaPeliculas=new ArrayList<>();
	String mensaje;
	
	public ListadoPeliculasDTO() {
		super();
	}
	
	
}
