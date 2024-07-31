package br.com.alura.owasp.dao;

import br.com.alura.owasp.model.Usuario;

public interface UsuarioDao {

	void salva(Usuario usuario);
	Usuario procuraUsuario(Usuario usuario);

}
