package com.example.demo.servicios.dto.relaciones.usuarioAnime;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class RelacionUsuarioAnimeDTO {

	long id;
	
	long idAnime;
	
	long idUsuario;
	
	int puntuacion;
	
	String estado;
	
	String nombreAnime;
	
	String notas;
	
	
	
	public RelacionUsuarioAnimeDTO() {
		super();
	}



	public RelacionUsuarioAnimeDTO(long idAnime, long idUsuario, int puntuacion, String estado, String notas) {
		this.idAnime = idAnime;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.notas = notas;
	}



	public RelacionUsuarioAnimeDTO(long id, long idAnime, long idUsuario, int puntuacion, String estado,
			String nombreAnime, String notas) {
		this.id = id;
		this.idAnime = idAnime;
		this.idUsuario = idUsuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.nombreAnime = nombreAnime;
		this.notas = notas;
	}

	
	
	



	

	
	
	
	
	
}
