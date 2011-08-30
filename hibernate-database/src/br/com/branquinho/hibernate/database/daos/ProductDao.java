package br.com.branquinho.hibernate.database.daos;

import br.com.branquinho.hibernate.database.entities.ProductEntity;
import br.com.branquinho.hibernate.database.interfaces.IProductDao;
import br.com.branquinho.hibernate.database.utils.GenericDao;

public class ProductDao extends GenericDao<ProductEntity, Long> implements
		IProductDao {

}
