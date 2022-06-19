package com.example.demo.servicios.dto.genero;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListadoGenerosDTO {
	List<GeneroDTO> listaGeneros=new ArrayList<>();
	String mensaje;
}
