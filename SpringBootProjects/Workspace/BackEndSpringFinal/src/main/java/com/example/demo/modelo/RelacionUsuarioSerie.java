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
public class RelacionUsuarioSerie {
	@Id
    Long id;
	
	@ManyToOne
	@JoinColumn(name="id_Anime")
	private Serie serie;
	
	@ManyToOne
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	
	@Column(name="PUNTUACION")
	float puntuacion;
	@Column(name="ESTADO")
	String estado;
}
