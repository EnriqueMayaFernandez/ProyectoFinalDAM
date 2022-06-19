package com.example.demo.servicios.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Genero;
import com.example.demo.modelo.Serie;
import com.example.demo.servicios.ServicioSerie;
import com.example.demo.servicios.dao.SerieDAO;
import com.example.demo.servicios.dto.genero.GeneroDTO;
import com.example.demo.servicios.dto.serie.ListadoSeriesDTO;
import com.example.demo.servicios.dto.serie.SerieDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;
import com.example.demo.utilidades.utils.Utilidades;

@Service
@Transactional
public class ServicioSerieImpl implements ServicioSerie {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	SerieDAO serieDAO;

	@Override
	public void insertarSerie(SerieDTO entrada) throws Exception {
		List<Serie> serieExiste = serieDAO.findByNombreSerie(entrada.getNombreSerie());
		if (serieExiste.size() == 0) {
			Genero genero = new Genero(entrada.getGenero().getId(), entrada.getGenero().getNombreGenero());
			Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
			Date fechaFinalizacion=Utilidades.ParseFecha(entrada.getFechaFinalizacion(),"yyyy-MM-dd");
			Serie serie = new Serie(entrada.getNombreSerie(), entrada.getDirector(), fechaEmision,
					fechaFinalizacion, entrada.getNumeroCapitulos(),genero);
			serieDAO.save(serie);
		} else {
			throw new EntidadExiste();
		}

	}

	@Override
	public void borrarSerie(long id) throws Exception {
		serieDAO.deleteById(id);

	}

	@Override
	public ListadoSeriesDTO getSeries() throws Exception {
		ListadoSeriesDTO listaSeries = new ListadoSeriesDTO();
		List<Serie> lista = serieDAO.findAllByOrderByNombreSerieAsc();
		for (Serie serie : lista) {
			String fechaFormateada1 = Utilidades.formatearFecha(serie.getFechaEmision(),"dd/MM/yyyy");
			String fechaFormateada2 = Utilidades.formatearFecha(serie.getFechaFinalizacion(),"dd/MM/yyyy");
			GeneroDTO generoDTO = new GeneroDTO(serie.getGenero().getId(), serie.getGenero().getNombreGenero());
			SerieDTO serieDTO = new SerieDTO(serie.getId(), serie.getNombreSerie(), serie.getDirector(),
					fechaFormateada1, fechaFormateada2, serie.getNumeroCapitulos(), generoDTO);
			listaSeries.getListaSeries().add(serieDTO);
		}
		return listaSeries;
	}

	@Override
	public void modificarSerie(SerieDTO entrada) throws NoSuchElementException, Exception {
		Serie existeSerie = serieDAO.getOne(entrada.getId());
		Genero genero = new Genero(entrada.getGenero().getId(), entrada.getGenero().getNombreGenero());
		Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
		Date fechaFinalizacion=Utilidades.ParseFecha(entrada.getFechaFinalizacion(),"yyyy-MM-dd");
		Serie serie = new Serie(entrada.getId(), entrada.getNombreSerie(), entrada.getDirector(),
				fechaEmision, fechaFinalizacion, entrada.getNumeroCapitulos(), genero);
		serieDAO.save(serie);

	}

	@Override
	public SerieDTO getSerie(long id) throws Exception {
		Serie serie = serieDAO.getOne(id);
		GeneroDTO generoDTO=new GeneroDTO(serie.getGenero().getId(),serie.getGenero().getNombreGenero());
		String fechaEmisionFormateada = Utilidades.formatearFecha(serie.getFechaEmision(),"yyyy-MM-dd");
		String fechaFinalizacionFormateada = Utilidades.formatearFecha(serie.getFechaFinalizacion(),"yyyy-MM-dd");
		SerieDTO serieDTO=new SerieDTO(serie.getId(),serie.getNombreSerie(),serie.getDirector(),fechaEmisionFormateada ,fechaFinalizacionFormateada,serie.getNumeroCapitulos(),generoDTO);
		return serieDTO;
	}
}
