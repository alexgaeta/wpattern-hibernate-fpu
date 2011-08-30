package br.com.branquinho.hibernate.utils.database.beans;

import java.util.List;

import br.com.branquinho.hibernate.utils.beans.BaseBean;

public class CategoryBean extends BaseBean {

	private static final long serialVersionUID = 617859634528108899L;

	private Long id;

	private String name;

	private String description;

	private List<ProductBean> products;

	public CategoryBean() {
	}

	public CategoryBean(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBean> products) {
		this.products = products;
	}

}
