package br.com.branquinho.hibernate.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbProduct")
public class ProductEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String description;

	private Double price;

	@ManyToOne
	private CategoryEntity category;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryEntity getCategory() {
		return this.category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
