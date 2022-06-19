package com.example.demo.servicios.dto.relaciones.usuarioSerie;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoRelacionUsuarioSerieDTO {
	List<RelacionUsuarioSerieDTO> listadoRelacionUsuarioSerie = new ArrayList<>();
	String mensaje;
}
