package br.com.branquinho.hibernate.database.interfaces;

public interface IDaoFactory {

	ICategoryDao getCategoryDao();

	IProductDao getProductDao();

}
