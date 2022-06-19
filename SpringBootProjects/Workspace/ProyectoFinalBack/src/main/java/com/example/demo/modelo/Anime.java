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
@Getter@Setter
@Table(name="ANIME")
public class Anime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_ANIME")
	String nombreAnime;
	@Column(name="ESTUDIO_ANIMACION")
	String estudioAnimacion;
	@Column(name="FECHA_EMISION")
	Date fechaEmision;
	@Column(name="FECHA_FINALIZACION")
	Date fechaFinalizacion;
	@Column(name="NUMERO_CAPITULOS")
	int numeroCapitulos;
	@ManyToOne
	@JoinColumn(name="idGenero")
	private Genero genero;
	@OneToMany(mappedBy="anime")
	private List<RelacionUsuarioAnime> relacionUsuarioAnime;
	
	public Anime() {
	}
	
	

	public Anime(String nombreAnime, String estudioAnimacion, Date fechaEmision, Date fechaFinalizacion,
			int numeroCapitulos, Genero genero) {
		this.nombreAnime = nombreAnime;
		this.estudioAnimacion = estudioAnimacion;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}
	
	public Anime(long id, String nombreAnime, String estudioAnimacion, Date fechaEmision,
			Date fechaFinalizacion, int numeroCapitulos, Genero genero) {
		this.id = id;
		this.nombreAnime = nombreAnime;
		this.estudioAnimacion = estudioAnimacion;
		this.fechaEmision = fechaEmision;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroCapitulos = numeroCapitulos;
		this.genero = genero;
	}


	
	
	
}
