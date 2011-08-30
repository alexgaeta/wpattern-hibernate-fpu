package br.com.branquinho.hibernate.database.daos;

import br.com.branquinho.hibernate.database.entities.CategoryEntity;
import br.com.branquinho.hibernate.database.interfaces.ICategoryDao;
import br.com.branquinho.hibernate.database.utils.GenericDao;

public class CategoryDao extends GenericDao<CategoryEntity, Long> implements
		ICategoryDao {

}
