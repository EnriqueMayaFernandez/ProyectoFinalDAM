package com.example.demo.servicios;



import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.pelicula.ListadoPeliculasDTO;
import com.example.demo.servicios.dto.pelicula.PeliculaDTO;

public interface ServicioPelicula {
	public void insertarPelicula(PeliculaDTO entrada) throws Exception;
	public void borrarPelicula(long id) throws Exception;
	public ListadoPeliculasDTO getPeliculas() throws Exception;
	public void modificarPelicula(PeliculaDTO entrada) throws NoSuchElementException, Exception;
	public PeliculaDTO getPelicula(long id) throws Exception;
}
