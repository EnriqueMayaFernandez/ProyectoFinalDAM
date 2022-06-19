package com.example.demo.servicios;



import com.example.demo.servicios.dto.SalidaListadoDTO;
import com.example.demo.servicios.dto.pelicula.EntradaPeliculaDTO;

public interface ServicioPelicula {
	public String insertarPelicula(EntradaPeliculaDTO entrada);
	public String borrarPelicula(int id);
	public SalidaListadoDTO getPeliculas();
}
