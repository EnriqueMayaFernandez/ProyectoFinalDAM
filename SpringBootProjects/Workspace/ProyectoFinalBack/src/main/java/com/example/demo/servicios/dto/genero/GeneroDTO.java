package com.example.demo.servicios.dto.genero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroDTO {
	long id;
	String nombreGenero;
	
	
	public GeneroDTO(long id, String nombreGenero) {
		this.id = id;
		this.nombreGenero = nombreGenero;
	}
	
	
}
