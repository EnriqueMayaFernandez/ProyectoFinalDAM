package com.example.demo.servicios.dto.relaciones.usuarioAnime;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoRelacionUsuarioAnimeDTO {

	List<RelacionUsuarioAnimeDTO> listadoRelacionUsuarioAnime=new ArrayList<>();
	String mensaje;
}
