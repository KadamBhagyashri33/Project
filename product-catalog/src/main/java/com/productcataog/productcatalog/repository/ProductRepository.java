package com.productcataog.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcataog.productcatalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// public List<Product> findAllProductByTitle(String title);

	// public List<Product> findAllProductsByCategory(Long id);
}
