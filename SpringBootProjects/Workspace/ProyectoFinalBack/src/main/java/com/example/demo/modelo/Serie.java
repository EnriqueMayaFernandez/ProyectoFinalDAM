package com.example.demo.modelo;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SERIE")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_SERIE")
	String nombreSerie;
	@Column(name = "IMAGEN_SERIE")
	String rutaImagenSerie;
	@Column(name = "DIRECTOR")
	String director;
	@Column(name = "FECHA_EMISION")
	Date fechaEmision;
	@Column(name = "FECHA_FINALIZACION")
	Date fechaFinalizacion;
	@Column(name = "NUMERO_CAPITULOS")
	int numeroCapitulos;
	@ManyToOne
	@JoinColumn(name = "idGenero")
	private Genero genero;
	@OneToMany(mappedBy = "serie")
	private List<RelacionUsuarioSerie> relacionUsuarioSerie;

	public Serie() {
		super();
	}

	public Serie(String nombreSerie, String director, Date fechaEmision, Date fechaFinalizacion, int numeroCapitulos,
			Genero genero) {
		this.nombreSerie = nombreSerie;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}

	public Serie(long id, String nombreSerie, String director, Date fechaEmision, Date fechaFinalizacion,
			int numeroCapitulos, Genero genero) {
		this.id = id;
		this.nombreSerie = nombreSerie;
		this.director = director;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}

}
