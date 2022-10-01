package com.productcataog.productcatalog.vo;

import java.math.BigDecimal;

public class ProductVO {

	private Long id;

	private String title;

	private BigDecimal price;

	private String short_description;

	private Long quantity;
   //Here we wont pass the object of category(use of vo resolver) we wont pass directly the object
	private String categoryTitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + id + ", title=" + title + ", price=" + price + ", short_description="
				+ short_description + ", quantity=" + quantity + ", categoryTitle=" + categoryTitle + "]";
	}

}
