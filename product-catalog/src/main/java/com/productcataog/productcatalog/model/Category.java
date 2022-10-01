package com.productcataog.productcatalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "catId")
	private Long id;

	@Column
	@NotNull
	private String categoryTitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryTitle=" + categoryTitle + "]";
	}
	

	/*
	 * we don't want to save the product when we create category so we dont need
	 * this mapping When we want both sides then use this .we can also use ENUM for
	 * this
	 * 
	 * @OneToOne(mappedBy = "category") private Product product;
	 */
	
}
