package br.com.alura.owasp.dao;

import br.com.alura.owasp.model.Usuario;
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
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());

		return query.getResultList().stream().findFirst().orElse(null);
	}

}
