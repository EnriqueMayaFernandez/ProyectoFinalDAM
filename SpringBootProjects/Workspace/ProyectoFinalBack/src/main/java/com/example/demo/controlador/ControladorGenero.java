package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicios.ServicioGenero;
import com.example.demo.servicios.dto.genero.ListadoGenerosDTO;

@RestController
@RequestMapping("/genero")
public class ControladorGenero {

	@Autowired
	ServicioGenero servicioGenero;
	
	@GetMapping("/get-generos")
	public ResponseEntity<ListadoGenerosDTO> getGeneros() {
		ListadoGenerosDTO salida=new ListadoGenerosDTO();
		try {
			salida=servicioGenero.getGeneros();
			salida.setMensaje("Se han recuperado los generos correctamente");
			return new ResponseEntity<ListadoGenerosDTO>(salida, HttpStatus.OK);
		} catch (Exception e) {
			salida.setMensaje("Ha ocurrido un error inesperado en la recuperacion de los generos");
			return new ResponseEntity<ListadoGenerosDTO>(salida,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
