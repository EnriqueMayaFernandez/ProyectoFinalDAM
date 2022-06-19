package com.example.demo.servicios.impl;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Pelicula;
import com.example.demo.servicios.ServicioPelicula;
import com.example.demo.servicios.dao.PeliculaDAO;
import com.example.demo.servicios.dto.SalidaListadoDTO;
import com.example.demo.servicios.dto.pelicula.EntradaPeliculaDTO;




public class ServicioPeliculaImpl implements ServicioPelicula{
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	PeliculaDAO peliculaDAO;
	
	
	
	@Override
	public String insertarPelicula(EntradaPeliculaDTO entrada) {
		String mensaje = "Cliente insertado con éxito.";
		
			Pelicula pelicula = new Pelicula(entrada.getNombrePelicula(),entrada.getRutaImagenPelicula(),
					entrada.getDirector(),entrada.getFechaEmision(),entrada.getDuracion(),entrada.getRelacionUsuarioPelicula());
			
			peliculaDAO.save(pelicula);

		return mensaje;
	}

	@Override
	public String borrarPelicula(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalidaListadoDTO getPeliculas() {
		// TODO Auto-generated method stub
		return null;
	}

}
