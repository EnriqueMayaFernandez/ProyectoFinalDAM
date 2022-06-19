package com.example.demo.servicios.dto.relaciones.usuarioSerie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelacionUsuarioSerieDTO {
	long id;

	long idSerie;

	long idUsuario;

	int puntuacion;

	String estado;

	String nombreSerie;

	String notas;

	public RelacionUsuarioSerieDTO() {
		super();
	}

	public RelacionUsuarioSerieDTO(long idSerie, long idUsuario, int puntuacion, String estado, String notas) {
		super();
		this.idSerie = idSerie;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.notas = notas;
	}

	public RelacionUsuarioSerieDTO(long id, long idSerie, long idUsuario, int puntuacion, String estado,
			String nombreSerie, String notas) {
		this.id = id;
		this.idSerie = idSerie;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.nombreSerie = nombreSerie;
		this.notas = notas;
	}
	
	
}
