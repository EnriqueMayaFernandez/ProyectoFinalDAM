package com.example.demo.servicios.dto.relaciones.usuarioPelicula;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelacionUsuarioPeliculaDTO {
	long id;

	long idPelicula;

	long idUsuario;

	int puntuacion;

	String estado;

	String nombrePelicula;

	String notas;

	public RelacionUsuarioPeliculaDTO() {
		super();
	}

	public RelacionUsuarioPeliculaDTO(long idPelicula, long idUsuario, int puntuacion, String estado, String notas) {
		this.idPelicula = idPelicula;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.notas = notas;
	}

	public RelacionUsuarioPeliculaDTO(long id, long idPelicula, long idUsuario, int puntuacion, String estado,
			String nombrePelicula, String notas) {
		this.id = id;
		this.idPelicula = idPelicula;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.nombrePelicula = nombrePelicula;
		this.notas = notas;
	}

}
