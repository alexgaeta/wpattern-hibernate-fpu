package br.com.branquinho.hibernate.utils.database.interfaces;

public interface IServicesFactory {

	ICategoryServices getCategoryService();

	IProductServices getProductServices();

}
