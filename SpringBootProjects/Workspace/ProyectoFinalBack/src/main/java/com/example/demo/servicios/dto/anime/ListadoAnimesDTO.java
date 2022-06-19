package com.example.demo.servicios.dto.anime;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoAnimesDTO {
	List<AnimeDTO> listaAnimes=new ArrayList<>();;
	String mensaje;
	
	public ListadoAnimesDTO() {
		super();
	}
	
	
	
}
