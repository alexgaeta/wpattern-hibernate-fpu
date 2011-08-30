package br.com.branquinho.hibernate.database.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbCategory")
public class CategoryEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String description;

	@OneToMany
	private List<ProductEntity> products;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

}
