package br.com.branquinho.hibernate.database.utils;

import org.hibernate.Session;

import br.com.branquinho.hibernate.database.daos.CategoryDao;
import br.com.branquinho.hibernate.database.daos.ProductDao;
import br.com.branquinho.hibernate.database.interfaces.ICategoryDao;
import br.com.branquinho.hibernate.database.interfaces.IDaoFactory;
import br.com.branquinho.hibernate.database.interfaces.IProductDao;

/**
 * Factory of daos.
 * 
 * @author augusto
 */
public class DaoFactory implements IDaoFactory {

	private final ICategoryDao categoryDao;

	private final IProductDao productDao;

	// ///////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTOR
	// ///////////////////////////////////////////////////////////////////////////////

	public DaoFactory() {
		this.categoryDao = (ICategoryDao) instantiateDao(CategoryDao.class);
		this.productDao = (IProductDao) instantiateDao(ProductDao.class);
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS
	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	public ICategoryDao getCategoryDao() {
		return this.categoryDao;
	}

	@Override
	public IProductDao getProductDao() {
		return this.productDao;
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PRIVATE METHODS
	// ///////////////////////////////////////////////////////////////////////////////

	private GenericDao<?, ?> instantiateDao(Class<?> daoClass) {

		try {
			GenericDao<?, ?> dao = (GenericDao<?, ?>) daoClass.newInstance();

			dao.setSession(getCurrentSession());

			return dao;
		} catch (Exception ex) {
			throw new RuntimeException(String.format(
					"Can not instantiate DAO %s with the error %s.", daoClass,
					ex.getMessage()), ex);
		}

	}

	private Session getCurrentSession() {
		return HibernateUtility.getSession();
	}

}
