package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.serie.ListadoSeriesDTO;
import com.example.demo.servicios.dto.serie.SerieDTO;


public interface ServicioSerie {
	public void insertarSerie(SerieDTO entrada) throws Exception;
	public void borrarSerie(long id) throws Exception;
	public ListadoSeriesDTO getSeries() throws Exception;
	public void modificarSerie(SerieDTO entrada) throws NoSuchElementException, Exception;
	public SerieDTO getSerie(long id) throws Exception;
}
