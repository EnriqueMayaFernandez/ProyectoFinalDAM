package com.example.demo.servicios.dto.pelicula;

import java.sql.Date;
import java.util.List;

import com.example.demo.modelo.RelacionUsuarioPelicula;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EntradaPeliculaDTO {
	
	String nombrePelicula;
	
	String rutaImagenPelicula;
	
	String Director;
	
	Date fechaEmision;
	
	float duracion;
	
	private List<RelacionUsuarioPelicula> relacionUsuarioPelicula;

	
}
