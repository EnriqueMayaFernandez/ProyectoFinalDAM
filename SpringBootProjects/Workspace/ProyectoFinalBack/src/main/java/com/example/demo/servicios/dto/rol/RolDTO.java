package com.example.demo.servicios.dto.rol;

import java.util.List;

import com.example.demo.modelo.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolDTO {

	long id;
	String tipo;
	private List<Usuario> usuarios;

	public RolDTO() {
		super();
	}

	public RolDTO(long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

}
