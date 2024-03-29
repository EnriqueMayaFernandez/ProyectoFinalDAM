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
@Getter@Setter
@Table(name="SERIE")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_SERIE")
	String nombreSerie;
	@Column(name="DIRECTOR")
	String director;
	@Column(name="FECHA_EMISION")
	Date fechaEmision;
	@Column(name="FECHA_FINALIZACION")
	Date fechaFinalizacion;
	@Column(name="NUMERO_CAPITULOS")
	int numeroCapitulos;
	@OneToMany(mappedBy="serie")
	private List<RelacionUsuarioSerie> relacionUsuarioSerie;
}
