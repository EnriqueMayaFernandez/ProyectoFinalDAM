package com.example.demo.servicios.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Pelicula;

public interface PeliculaDAO extends CrudRepository<Pelicula, Long>{

}
