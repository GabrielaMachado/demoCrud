package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean crearUsuario(String nombre, String edad) {
		Usuario usuario = new Usuario(nombre, Integer.parseInt(edad));
		return usuarioRepository.crearUsuario(usuario);
	}

	public boolean eliminarUsuario(String nombreUsuario) {
		Usuario usuario = usuarioRepository.buscarUsuario(nombreUsuario);
		return usuarioRepository.eliminarUsuario(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

	public boolean modificarUsuario(String nombreUsuario, String nombreNuevo, String edad) {
		try {
			int pos = usuarioRepository.buscarPosicion(nombreUsuario);
			if (pos > -1) {
				return usuarioRepository.modificarUsuario(pos, new Usuario(nombreNuevo, Integer.parseInt(edad)));
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
