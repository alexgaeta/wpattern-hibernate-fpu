package br.com.branquinho.hibernate.utils.database.interfaces;

import java.util.List;

import br.com.branquinho.hibernate.utils.database.beans.CategoryBean;


public interface ICategoryServices {

	CategoryBean findById(Long id);

	List<CategoryBean> findAllCategories();

	Long insert(CategoryBean category);

	void update(CategoryBean category);

	void delete(CategoryBean category);

}
