package com.example.demo.servicios.dto.usuario;

import com.example.demo.servicios.dto.rol.RolDTO;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UsuarioDTO {
	
	long id;

	String nombreUsuario;

	String clave;

	private RolDTO rol;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(long id, String nombreUsuario, String clave, RolDTO rol) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.rol = rol;
	}
	
	
	
	
	
}
