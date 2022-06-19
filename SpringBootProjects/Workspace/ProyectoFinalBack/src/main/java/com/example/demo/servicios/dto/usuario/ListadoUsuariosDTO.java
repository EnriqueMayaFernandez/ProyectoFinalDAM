package com.example.demo.servicios.dto.usuario;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoUsuariosDTO {
	List<UsuarioDTO> listaUsuarios = new ArrayList<>();
	String mensaje;
}
