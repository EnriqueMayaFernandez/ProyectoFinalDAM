package com.example.demo.servicios.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Rol;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicios.ServicioUsuario;
import com.example.demo.servicios.dao.RolDAO;
import com.example.demo.servicios.dao.UsuarioDAO;
import com.example.demo.servicios.dto.rol.RolDTO;
import com.example.demo.servicios.dto.usuario.ListadoUsuariosDTO;
import com.example.demo.servicios.dto.usuario.LoginDTO;
import com.example.demo.servicios.dto.usuario.UsuarioDTO;
import com.example.demo.utilidades.excepciones.EntidadExiste;
import com.example.demo.utilidades.excepciones.ErrorLogin;

@Service
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	UsuarioDAO usuarioDAO;

	@Autowired
	RolDAO rolDAO;

	@Override
	public void insertarUsuario(UsuarioDTO entrada) throws EntidadExiste, Exception {
		List<Usuario> usuarioExiste = getListaUsuariosPorNombre(entrada);
		if (usuarioExiste.size() == 0) {
			Rol rol=new Rol();
			rol.setId(entrada.getRol().getId());
			Usuario usuario = new Usuario(entrada.getNombreUsuario(), entrada.getClave(), rol);
			usuarioDAO.save(usuario);
		} else {
			throw new EntidadExiste();
		}
	}

	@Override
	public void borrarUsuario(long id) throws Exception {
		usuarioDAO.deleteById(id);
	}

	@Override
	public ListadoUsuariosDTO getUsuarios() throws Exception {
		ListadoUsuariosDTO listaUsuarios = new ListadoUsuariosDTO();
		List<Usuario> lista=usuarioDAO.findAllByOrderByNombreUsuarioAsc();
		for(Usuario usuario:lista) {
		RolDTO rolDTO=new RolDTO(usuario.getRol().getId(),usuario.getRol().getTipo());
		UsuarioDTO usuarioDTO=new UsuarioDTO(usuario.getId(),usuario.getNombreUsuario(),usuario.getContraseña(),rolDTO);
		listaUsuarios.getListaUsuarios().add(usuarioDTO);
		}
		return listaUsuarios;
	}

	@Override
	public void modificarUsuario(UsuarioDTO entrada) throws NoSuchElementException, Exception {
		Rol rol=new Rol();
		rol.setId(entrada.getRol().getId());
		Usuario usuario = new Usuario(entrada.getId(),entrada.getNombreUsuario(), entrada.getClave(), rol);
		usuarioDAO.save(usuario);
	}

	@Override
	public LoginDTO logeoUsuario(UsuarioDTO entrada) throws ErrorLogin {
		int codigoLogeo = 0;
		String mensaje = "";
		LoginDTO loginDTO;
		try {
			List<Usuario> listadoUsuarios = getListaUsuariosPorNombre(entrada);
			Usuario usuario = listadoUsuarios.get(0);
			if (entrada.getClave().equals(listadoUsuarios.get(0).getContraseña())) {
				mensaje = "Se ha logeado correctamente";
				if (listadoUsuarios.get(0).getRol().getTipo().equals("Admin")) {
					codigoLogeo = 2;
				} else {
					codigoLogeo = 1;
				}
			}
			if (codigoLogeo == 0) {
				mensaje = "Error al intentar logearse revise el nombre y la contraseña que ha introducido";
				throw new ErrorLogin();
			}
			loginDTO = new LoginDTO(usuario.getId(), usuario.getNombreUsuario(), mensaje, codigoLogeo);
		} catch (Exception e) {
			mensaje = "Error al intentar logearse revise el nombre y la contraseña que ha introducido";
			loginDTO = new LoginDTO(0,"", mensaje, codigoLogeo);
		}
		return loginDTO;
	}

	private List<Usuario> getListaUsuariosPorNombre(UsuarioDTO entrada) {
		List<Usuario> listadoUsuarios;
		listadoUsuarios = usuarioDAO.findByNombreUsuario(entrada.getNombreUsuario());
		return listadoUsuarios;
	}

	@Override
	public UsuarioDTO getUsuario(long id) {
		Usuario usuario = usuarioDAO.getOne(id);
		RolDTO rolDTO=new RolDTO(usuario.getRol().getId(),usuario.getRol().getTipo());
		UsuarioDTO usuarioDTO=new UsuarioDTO(usuario.getId(),usuario.getNombreUsuario(),usuario.getContraseña(),rolDTO);
		return usuarioDTO;
	}
}
