package com.example.demo.modelo;

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
@Getter@Setter
@Table(name="GENERO")
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_GENERO")
	String nombreGenero;
	@OneToMany(mappedBy="genero")
	private List<Pelicula> peliculas;
	@OneToMany(mappedBy="genero")
	private List<Anime> animes;
	@OneToMany(mappedBy="genero")
	private List<Serie> series;
	
	
	public Genero() {
		super();
	}
	
	
	
	public Genero(long id, String nombreGenero) {
		this.id = id;
		this.nombreGenero = nombreGenero;
	}





	
	
	
}
