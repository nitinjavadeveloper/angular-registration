package org.learn.app.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.learn.app.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl {

	@PersistenceContext
	private EntityManager entityManager;

	// list of all data

	@SuppressWarnings("unchecked")
	public List<Users> getAll() {
		return entityManager.createQuery("from Users").getResultList();
	}

	/**
	 * Save the employee in the database.
	 */

	public Users saveUser(Users user) {

		entityManager.persist(user);
		int id = user.getEmpId();
		return entityManager.find(Users.class, id);
	}
}
