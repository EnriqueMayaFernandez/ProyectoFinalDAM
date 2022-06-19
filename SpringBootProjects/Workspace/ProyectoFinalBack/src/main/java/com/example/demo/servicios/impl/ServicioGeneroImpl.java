package com.example.demo.servicios.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Genero;
import com.example.demo.servicios.ServicioGenero;
import com.example.demo.servicios.dao.GeneroDAO;
import com.example.demo.servicios.dto.genero.GeneroDTO;
import com.example.demo.servicios.dto.genero.ListadoGenerosDTO;

@Service
@Transactional
public class ServicioGeneroImpl implements ServicioGenero{

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	GeneroDAO generoDAO;
	
	@Override
	public ListadoGenerosDTO getGeneros() throws Exception {
		ListadoGenerosDTO listaGeneros = new ListadoGenerosDTO();
		try {
		List<Genero> lista=generoDAO.findAllByOrderByNombreGeneroAsc();
		for(Genero genero:lista) {
		GeneroDTO generoDTO=new GeneroDTO(genero.getId(),genero.getNombreGenero());
		listaGeneros.getListaGeneros().add(generoDTO);
		}
		}catch(JpaSystemException e) {
			e.printStackTrace();
		}
		return listaGeneros;
	}

}
