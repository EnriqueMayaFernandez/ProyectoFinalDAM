package com.example.demo.servicios.dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

	long id;

	String nombreUsuario;
	
	String mensaje;
	
	int codigoLogeo;
	
	
	public LoginDTO() {
	}

	public LoginDTO(long id, String nombreUsuario, String mensaje, int codigoLogeo) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.mensaje = mensaje;
		this.codigoLogeo = codigoLogeo;
	}
	
	
	
	
}
