package com.example.demo.servicios;

import java.util.NoSuchElementException;

import com.example.demo.servicios.dto.usuario.ListadoUsuariosDTO;
import com.example.demo.servicios.dto.usuario.LoginDTO;
import com.example.demo.servicios.dto.usuario.UsuarioDTO;
import com.example.demo.utilidades.excepciones.ErrorLogin;

public interface ServicioUsuario {
	public void insertarUsuario(UsuarioDTO entrada) throws Exception;
	public void borrarUsuario(long id) throws Exception;
	public ListadoUsuariosDTO getUsuarios() throws Exception;
	public void modificarUsuario(UsuarioDTO entrada) throws NoSuchElementException, Exception;
	public LoginDTO logeoUsuario(UsuarioDTO entrada) throws ErrorLogin;
	public UsuarioDTO getUsuario(long id);
}
