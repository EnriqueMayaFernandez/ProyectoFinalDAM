package com.example.demo.servicios.dto.serie;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoSeriesDTO {
	List<SerieDTO> listaSeries=new ArrayList<>();;
	String mensaje;
	
	public ListadoSeriesDTO() {
		super();
	}
	
	
}
