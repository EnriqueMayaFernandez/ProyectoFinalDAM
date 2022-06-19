package com.example.demo.servicios.dto.rol;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoRolesDTO {
	List<RolDTO> listaRoles;
	String mensaje;
}
