package com.example.demo.servicios.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Genero;
import com.example.demo.modelo.Pelicula;
import com.example.demo.servicios.ServicioPelicula;
import com.example.demo.servicios.dao.PeliculaDAO;
import com.example.demo.servicios.dto.genero.GeneroDTO;
import com.example.demo.servicios.dto.pelicula.ListadoPeliculasDTO;
import com.example.demo.servicios.dto.pelicula.PeliculaDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;
import com.example.demo.utilidades.utils.Utilidades;

@Service
@Transactional
public class ServicioPeliculaImpl implements ServicioPelicula{
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	PeliculaDAO peliculaDAO;

	@Override
	public void insertarPelicula(PeliculaDTO entrada) throws Exception {
		List<Pelicula> peliculaExiste = peliculaDAO.findByNombrePelicula(entrada.getNombrePelicula());
		if (peliculaExiste.size() == 0) {
			Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
			Genero genero=new Genero(entrada.getGenero().getId(),entrada.getGenero().getNombreGenero());			Pelicula pelicula = new Pelicula(entrada.getNombrePelicula(), entrada.getDirector(),
					fechaEmision, entrada.getDuracion(), genero);
			peliculaDAO.save(pelicula);
		} else {
			throw new EntidadExiste();
		}

	}

	@Override
	public void borrarPelicula(long id) throws Exception {
		peliculaDAO.deleteById(id);

	}

	@Override
	public ListadoPeliculasDTO getPeliculas() throws Exception {
		ListadoPeliculasDTO listaPeliculas = new ListadoPeliculasDTO();
		try {
		List<Pelicula> lista=peliculaDAO.findAllByOrderByNombrePeliculaAsc();
		for(Pelicula pelicula:lista) {
		GeneroDTO generoDTO=new GeneroDTO(pelicula.getGenero().getId(),pelicula.getGenero().getNombreGenero());
		String fechaFormateada=Utilidades.formatearFecha(pelicula.getFechaEmision(),"dd/MM/yyyy");
		PeliculaDTO peliculaDTO=new PeliculaDTO(pelicula.getId(),pelicula.getNombrePelicula(),pelicula.getDirector(),fechaFormateada,pelicula.getDuracion(),generoDTO);
		listaPeliculas.getListaPeliculas().add(peliculaDTO);
		}
		}catch(JpaSystemException e) {
			e.printStackTrace();
		}
		return listaPeliculas;
	}

	@Override
	public void modificarPelicula(PeliculaDTO entrada) throws NoSuchElementException, Exception {
		Pelicula existePelicula = peliculaDAO.getOne(entrada.getId());
		Genero genero=new Genero(entrada.getGenero().getId(),entrada.getGenero().getNombreGenero());
		Date fechaEmision=Utilidades.ParseFecha(entrada.getFechaEmision(),"yyyy-MM-dd");
		Pelicula pelicula = new Pelicula(entrada.getId(), entrada.getNombrePelicula(), entrada.getDirector(),
				fechaEmision, entrada.getDuracion(), genero);
		peliculaDAO.save(pelicula);
	}
	
	@Override
	public PeliculaDTO getPelicula(long id) throws Exception {
		Pelicula pelicula = peliculaDAO.getOne(id);
		GeneroDTO generoDTO=new GeneroDTO(pelicula.getGenero().getId(),pelicula.getGenero().getNombreGenero());
		String fechaEmisionFormateada = Utilidades.formatearFecha(pelicula.getFechaEmision(),"yyyy-MM-dd");
		PeliculaDTO peliculaDTO=new PeliculaDTO(pelicula.getId(),pelicula.getNombrePelicula(),pelicula.getDirector(),fechaEmisionFormateada,pelicula.getDuracion(),generoDTO);
		return peliculaDTO;
	}

}
