package com.example.demo.servicios.dto.relaciones.usuarioPelicula;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoRelacionUsuarioPeliculaDTO {
	List<RelacionUsuarioPeliculaDTO> listadoRelacionUsuarioPelicula=new ArrayList<>();
	String mensaje;
}
