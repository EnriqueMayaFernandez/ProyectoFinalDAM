package com.example.demo.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PELICULA")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_PELICULA")
	String nombrePelicula;
	@Column(name = "IMAGEN_PELICULA")
	String rutaImagenPelicula;
	@Column(name="DIRECTOR")
	String Director;
	@Column(name="FECHA_EMISION")
	Date fechaEmision;
	@Column(name="DURACION")
	float duracion;
	@OneToMany(mappedBy="pelicula")
	private List<RelacionUsuarioPelicula> relacionUsuarioPelicula;
	
	
	public Pelicula(String nombrePelicula, String rutaImagenPelicula, String director, Date fechaEmision,
			float duracion, List<RelacionUsuarioPelicula> relacionUsuarioPelicula) {
		super();
		this.nombrePelicula = nombrePelicula;
		this.rutaImagenPelicula = rutaImagenPelicula;
		Director = director;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
		this.relacionUsuarioPelicula = relacionUsuarioPelicula;
	}
	
	

	
	
	
}
