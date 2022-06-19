package com.example.demo.servicios.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Pelicula;
import com.example.demo.modelo.RelacionUsuarioPelicula;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.ServicioRelacionUsuarioPelicula;
import com.example.demo.servicios.dao.RelacionUsuarioPeliculaDAO;
import com.example.demo.servicios.dto.relaciones.usuarioPelicula.ListadoRelacionUsuarioPeliculaDTO;
import com.example.demo.servicios.dto.relaciones.usuarioPelicula.RelacionUsuarioPeliculaDTO;

@Service
@Transactional
public class ServicioRelacionUsuarioPeliculaImpl implements ServicioRelacionUsuarioPelicula{
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	RelacionUsuarioPeliculaDAO relacionUsuarioPeliculaDAO;

	@Override
	public void insertarRelacionUsuarioPelicula(RelacionUsuarioPeliculaDTO entrada) throws Exception {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(entrada.getIdPelicula());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioPelicula relacionUsuarioPelicula = new RelacionUsuarioPelicula(entrada.getId(),pelicula, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioPeliculaDAO.save(relacionUsuarioPelicula);
	}

	@Override
	public void borrarRelacionUsuarioPelicula(long id) throws Exception {
		relacionUsuarioPeliculaDAO.deleteById(id);

	}

	@Override
	public ListadoRelacionUsuarioPeliculaDTO getRelacionesUsuarioPelicula() throws Exception {
		ListadoRelacionUsuarioPeliculaDTO listaRelacionUsuarioPelicula = new ListadoRelacionUsuarioPeliculaDTO();
		List<RelacionUsuarioPelicula> lista = relacionUsuarioPeliculaDAO.findAll();
		for (RelacionUsuarioPelicula relacionUsuarioPelicula : lista) {
			RelacionUsuarioPeliculaDTO relacionUsuarioPeliculaDTO = new RelacionUsuarioPeliculaDTO(
					relacionUsuarioPelicula.getId(), relacionUsuarioPelicula.getPelicula().getId(),
					relacionUsuarioPelicula.getUsuario().getId(), relacionUsuarioPelicula.getPuntuacion(),
					relacionUsuarioPelicula.getEstado(),relacionUsuarioPelicula.getPelicula().getNombrePelicula(),relacionUsuarioPelicula.getNotas());
			listaRelacionUsuarioPelicula.getListadoRelacionUsuarioPelicula().add(relacionUsuarioPeliculaDTO);
		}
		return listaRelacionUsuarioPelicula;
	}

	@Override
	public void modificarRelacionUsuarioPelicula(RelacionUsuarioPeliculaDTO entrada)
			throws NoSuchElementException, Exception {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(entrada.getIdPelicula());
		Usuario usuario = new Usuario();
		usuario.setId(entrada.getIdUsuario());
		RelacionUsuarioPelicula relacionUsuarioPelicula = new RelacionUsuarioPelicula(entrada.getId(), pelicula, usuario,
				entrada.getPuntuacion(), entrada.getEstado(),entrada.getNotas());
		relacionUsuarioPeliculaDAO.save(relacionUsuarioPelicula);
	}

	@Override
	public RelacionUsuarioPeliculaDTO getRelacionUsuarioPelicula(long id) throws Exception {
		RelacionUsuarioPelicula relacionUsuarioPelicula = relacionUsuarioPeliculaDAO.getOne(id);
		RelacionUsuarioPeliculaDTO relacionUsuarioPeliculaDTO=new RelacionUsuarioPeliculaDTO(relacionUsuarioPelicula.getId(), relacionUsuarioPelicula.getPelicula().getId(),
				relacionUsuarioPelicula.getUsuario().getId(), relacionUsuarioPelicula.getPuntuacion(),
				relacionUsuarioPelicula.getEstado(),relacionUsuarioPelicula.getPelicula().getNombrePelicula(),relacionUsuarioPelicula.getNotas());
		return relacionUsuarioPeliculaDTO;
	}
}
