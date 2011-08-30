package br.com.branquinho.hibernate.database.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.branquinho.hibernate.database.ServicesFactory;
import br.com.branquinho.hibernate.database.interfaces.IDaoFactory;
import br.com.branquinho.hibernate.database.utils.DaoFactory;
import br.com.branquinho.hibernate.utils.database.beans.CategoryBean;
import br.com.branquinho.hibernate.utils.database.beans.ProductBean;
import br.com.branquinho.hibernate.utils.database.interfaces.IServicesFactory;

public class ServicesDatabaseTest {

	private static final Logger logger = Logger.getLogger(ServicesDatabaseTest.class);

	private static final IDaoFactory daoFactory = new DaoFactory();

	private static final IServicesFactory serviceFactory = new ServicesFactory(daoFactory);

	@BeforeClass
	public static void beforeClass() {
		logger.info("Instantiate DAO Factory and Service Factory.");
	}

	@Test
	public void testFindAll() {

		logger.info("Find all registers.");

		// Find all categories.
		List<CategoryBean> categories = serviceFactory.getCategoryService().findAllCategories();

		for (CategoryBean category : categories) {
			logger.info(String.format("Category [%s]", category));
		}

		// Find all products.
		List<ProductBean> products = serviceFactory.getProductServices().findAllProducts();

		for (ProductBean product : products) {
			logger.info(String.format("Product [%s]", product));
		}
	}

	@Test
	public void testInsert() {
		logger.info("Testing insertion.");

		// Test insert a category.
		String tmpCategory = "Category 05";

		CategoryBean category = new CategoryBean();

		category.setDescription(String.format("Description of the %s.", tmpCategory));
		category.setName(String.format("Name %s.", tmpCategory));

		Long idCategory = serviceFactory.getCategoryService().insert(category);

		// Test insert a product.
		String tmpProduct = "Product 05";

		ProductBean product = new ProductBean();

		product.setDescription(String.format("Description of the %s.", tmpProduct));
		product.setName(String.format("Name %s.", tmpProduct));
		product.setPrice(12.02d);
		product.setCategory(new CategoryBean(idCategory));

		serviceFactory.getProductServices().insert(product);
	}

}
