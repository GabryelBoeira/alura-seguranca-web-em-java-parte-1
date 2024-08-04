package br.com.alura.owasp.dao;

import br.com.alura.owasp.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Saves the given user to the database.
	 *
	 * @param  usuario the user object to be saved
	 */
	public void salva(Usuario usuario) {

		// criptografando a senha do usuário
		usuario.setSenha(BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt()));
		manager.persist(usuario);
	}

	/**
	 * Retrieves a user from the database based on the provided email and password.
	 *
	 * @param  usuario the user object containing the email and password to search for
	 * @return         the user object if found, null otherwise
	 * @throws RuntimeException if an error occurs while executing the database query
	 */
	public Usuario procuraUsuario(Usuario usuario) {

		TypedQuery<Usuario> query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
		query.setParameter("email", usuario.getEmail());

		// verifica se a senha do usuário bate com o hash do usuário
		Usuario usuarioRetornado = query.getResultList().stream().findFirst().orElse(null);
		if (validaSenhaUsuariomOHashBanco(usuario, usuarioRetornado)) {
			return usuarioRetornado;
		};

		return null;
	}

	/**
	 * Validates the password of a user against the hashed password stored in the database.
	 *
	 * @param  usuario       the user object containing the password to be validated
	 * @param  usuarioRetornado the user object retrieved from the database
	 * @return                true if the password matches the hashed password, false otherwise
	 */
	private boolean validaSenhaUsuariomOHashBanco(Usuario usuario, Usuario usuarioRetornado) {
		if (usuarioRetornado == null) return false;

		return BCrypt.checkpw(usuario.getSenha(), usuarioRetornado.getSenha());
	}

}
