package com.example.demo.servicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Pelicula;

public interface PeliculaDAO extends JpaRepository<Pelicula, Long>{
	List<Pelicula>  findByNombrePelicula(String nombrePelicula);
	List<Pelicula> findAllByOrderByNombrePeliculaAsc();
}
