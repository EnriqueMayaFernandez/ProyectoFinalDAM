package com.example.demo.modelo;

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
@Table(name="USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "NOMBRE_USUARIO")
	String nombreUsuario;
	@Column(name = "CONTRASEÑA")
	String contraseña;
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;
	@OneToMany(mappedBy="usuario")
	private List<RelacionUsuarioPelicula> relacionUsuarioPelicula;
	@OneToMany(mappedBy="usuario")
	private List<RelacionUsuarioSerie> relacionUsuarioSerie;
	@OneToMany(mappedBy="usuario")
	private List<RelacionUsuarioAnime> relacionUsuarioAnime;
	
	
	
	public Usuario() {
		super();
	}
	
	
	public Usuario(String nombreUsuario, String contraseña, Rol rol) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.rol = rol;
	}





	public Usuario(long id, String nombreUsuario, String contraseña, Rol rol) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.rol = rol;
	}





	
	
	
	
}
