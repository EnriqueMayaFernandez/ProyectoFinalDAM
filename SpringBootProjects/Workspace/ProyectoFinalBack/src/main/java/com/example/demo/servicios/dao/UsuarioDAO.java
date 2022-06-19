package com.example.demo.servicios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	List<Usuario>  findByNombreUsuario(String nombreUsuario);
	List<Usuario> findAllByOrderByNombreUsuarioAsc();
}
