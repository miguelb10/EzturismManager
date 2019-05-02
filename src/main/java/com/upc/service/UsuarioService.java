package com.upc.service;

import com.upc.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario>{
	Usuario findByUsername(String username);
}
