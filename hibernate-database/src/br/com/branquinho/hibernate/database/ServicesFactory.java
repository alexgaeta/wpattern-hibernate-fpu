package br.com.branquinho.hibernate.database;

import br.com.branquinho.hibernate.database.interfaces.IDaoFactory;
import br.com.branquinho.hibernate.database.services.CategoryServices;
import br.com.branquinho.hibernate.database.services.ProductServices;
import br.com.branquinho.hibernate.database.utils.DaoFactory;
import br.com.branquinho.hibernate.utils.database.interfaces.ICategoryServices;
import br.com.branquinho.hibernate.utils.database.interfaces.IProductServices;
import br.com.branquinho.hibernate.utils.database.interfaces.IServicesFactory;

/**
 * Factory of services.
 *
 * @author augusto
 */
public class ServicesFactory implements IServicesFactory {

	private final ICategoryServices categoryServices;

	private final IProductServices productServices;

	// ///////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	// ///////////////////////////////////////////////////////////////////////////////

	public ServicesFactory() {
		IDaoFactory daoFactory = new DaoFactory();

		this.categoryServices = new CategoryServices(daoFactory);
		this.productServices = new ProductServices(daoFactory);
	}

	public ServicesFactory(IDaoFactory daoFactory) {
		this.categoryServices = new CategoryServices(daoFactory);
		this.productServices = new ProductServices(daoFactory);
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS (IServicesFactory)
	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	public ICategoryServices getCategoryService() {
		return this.categoryServices;
	}

	@Override
	public IProductServices getProductServices() {
		return this.productServices;
	}

}
