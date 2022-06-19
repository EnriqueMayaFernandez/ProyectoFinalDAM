package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter@Setter
@Table(name = "RelacionUsuarioSerie")
public class RelacionUsuarioSerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
	
	@ManyToOne
	@JoinColumn(name="id_Anime")
	private Serie serie;
	
	@ManyToOne
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	
	@Column(name="PUNTUACION")
	int puntuacion;
	@Column(name="ESTADO")
	String estado;
	@Column(name="NOTAS")
	String notas;
	
	
	public RelacionUsuarioSerie() {
		super();
	}
	
	public RelacionUsuarioSerie(Serie serie, Usuario usuario, int puntuacion, String estado, String notas) {
		this.serie = serie;
		this.usuario = usuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.notas = notas;
	}
	
	public RelacionUsuarioSerie(Long id, Serie serie, Usuario usuario, int puntuacion, String estado, String notas) {
		this.id = id;
		this.serie = serie;
		this.usuario = usuario;
		this.puntuacion = puntuacion;
		this.estado = estado;
		this.notas = notas;
	}
	
	
}
