package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class RelacionUsuarioPelicula {
	
	@Id
    Long id;
	
	@ManyToOne
	@JoinColumn(name="id_Pelicula")
	private Pelicula pelicula;
	
	@ManyToOne
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	
	@Column(name="PUNTUACION")
	float puntuacion;
	@Column(name="ESTADO")
	String estado;
	
}
