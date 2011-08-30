package br.com.branquinho.hibernate.utils.database.interfaces;

import java.util.List;

import br.com.branquinho.hibernate.utils.database.beans.ProductBean;

public interface IProductServices {

	ProductBean findById(Long id);

	List<ProductBean> findAllProducts();

	Long insert(ProductBean product);

	void update(ProductBean product);

	void delete(ProductBean product);

}
