package br.com.branquinho.hibernate.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import br.com.branquinho.hibernate.database.interfaces.IGenericDao;

/**
 * Generic dao used to access the database.
 *
 * @author augusto
 *
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDao<T, ID extends Serializable> implements
		IGenericDao<T, ID> {

	/**
	 * Logger.
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Used to retrieve information about a class (entity).
	 */
	private final Class<T> persistentClass;

	/**
	 * Session with the database.
	 */
	private Session session;

	// ///////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	// ///////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS (IGenericDao<T, ID>)
	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) getSession().load(getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	@Override
	@SuppressWarnings("unchecked")
	public ID save(T entity) {

		getSession().beginTransaction();
		Serializable id = getSession().save(entity);
		getSession().getTransaction().commit();

		return (ID)id;

	}

	@Override
	public void update(T entity) {
		getSession().beginTransaction();
		getSession().update(entity);
		getSession().getTransaction().commit();
	}

	@Override
	public void delete(T entity) {
		getSession().beginTransaction();
		getSession().delete(entity);
		getSession().getTransaction().commit();
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// GET AND SET METHODS
	// ///////////////////////////////////////////////////////////////////////////////

	public Session getSession() {

		if (this.session == null) {
			this.logger.error("Session not founded.");

			throw new IllegalStateException(
					"Session has not been set on DAO before usage");
		}

		return this.session;

	}

	public void setSession(Session s) {
		this.session = s;
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PRIVATE METHODS
	// ///////////////////////////////////////////////////////////////////////////////

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@SuppressWarnings("unchecked")
	private List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());

		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();
	}

}
