package br.com.branquinho.hibernate.database;

import org.apache.log4j.Logger;

public class HibernateMain {

	/**
	 * Logger.
	 */
	private static final Logger logger = Logger.getLogger(HibernateMain.class);

	public static void main(String[] args) {

		logger.info("Starting the program.");

//
//
//		// Test save a category.
//		String tmpCategory = "Category 04";
//
//		CategoryBean category = new CategoryBean();
//
//		category.setDescription(String.format("Description of the %s.", tmpCategory));
//		category.setName(String.format("Name %s.", tmpCategory));
//
//		Long idCategory = serviceFactory.getCategoryService().save(category);
//
//		// Test save a product.
//		String tmpProduct = "Product 04";
//
//		ProductBean product = new ProductBean();
//
//		product.setDescription(String.format("Description of the %s.", tmpProduct));
//		product.setName(String.format("Name %s.", tmpProduct));
//		product.setPrice(12.02d);
//
//		CategoryBean categoryToProduct = new CategoryBean();
//
//		categoryToProduct.setId(idCategory);
//
//		product.setCategory(categoryToProduct);
//
//		serviceFactory.getProductServices().save(product);

	}

}
