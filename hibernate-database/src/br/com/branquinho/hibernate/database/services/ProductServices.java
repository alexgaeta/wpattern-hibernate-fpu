package br.com.branquinho.hibernate.database.services;

import java.util.List;

import br.com.branquinho.hibernate.database.interfaces.IDaoFactory;
import br.com.branquinho.hibernate.database.interfaces.IProductDao;
import br.com.branquinho.hibernate.database.utils.ParserDatabase;
import br.com.branquinho.hibernate.utils.database.beans.ProductBean;
import br.com.branquinho.hibernate.utils.database.interfaces.IProductServices;

public class ProductServices implements IProductServices {

	private final IProductDao productDao;

	// ///////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	// ///////////////////////////////////////////////////////////////////////////////

	public ProductServices(IDaoFactory daoFactory) {
		this.productDao = daoFactory.getProductDao();
	}

	// ///////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS (IProductServices)
	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	public ProductBean findById(Long id) {
		return ParserDatabase.parserEntityToBean(this.productDao.findById(id));
	}

	@Override
	public List<ProductBean> findAllProducts() {
		return ParserDatabase.parseProductEntitiesToBeans(this.productDao.findAll());
	}

	@Override
	public Long insert(ProductBean product) {
		return this.productDao.save(ParserDatabase.parserBeanToEntity(product));
	}

	@Override
	public void update(ProductBean product) {
		this.productDao.update(ParserDatabase.parserBeanToEntity(product));
	}

	@Override
	public void delete(ProductBean product) {
		this.productDao.delete(ParserDatabase.parserBeanToEntity(product));
	}

}
