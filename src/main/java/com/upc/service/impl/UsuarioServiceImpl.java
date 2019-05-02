package com.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.entity.Usuario;
import com.upc.repository.UsuarioRepository;
import com.upc.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario registrar(Usuario t) {
		return usuarioRepository.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		return usuarioRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

}
