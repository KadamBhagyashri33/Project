package com.productcataog.productcatalog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productcataog.productcatalog.model.Category;
import com.productcataog.productcatalog.model.Product;
import com.productcataog.productcatalog.repository.CategoryRepository;
import com.productcataog.productcatalog.repository.ProductRepository;
import com.productcataog.productcatalog.service.ProductService;
import com.productcataog.productcatalog.vo.ProductVO;

import ch.qos.logback.classic.Logger;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository catRepo;

	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(this.getClass());

	/*
	 * you will get productVO as input here, from product vo get cat title and fetch
	 * category entity convert product vo to product entity and set fetched category
	 * entity then call save on product you will get saved product convert product
	 * to product vo it won't convert cat title so seperately get category entity
	 * from prod entity , from that fetch category title and set that in the product
	 * vo pass that back to UI
	 */
	@Override
	public ProductVO addProduct(ProductVO productVo) {

		String titleFromVo = productVo.getCategoryTitle();

		Category categoryFromDB = catRepo.findByCategoryTitle(titleFromVo);

		Product product = voToEntity(productVo);

		product.setCategory(categoryFromDB);

		Product savedProduct = productRepo.save(product);
		
		LOGGER.info("getAllProduct savedProduct s {}", savedProduct);

		productVo.setId(savedProduct.getId());

		return productVo;
	}

	@Override
	public List<ProductVO> getAllProducts() {
		LOGGER.info("getAllProducts {}");
		List<Product> productsFromDB = productRepo.findAll();
		List<ProductVO> productVOs = new ArrayList<>();
		for(Product product :productsFromDB) {
			Category category = product.getCategory();
			String catTittle = category.getCategoryTitle();
			ProductVO productvo = entityToVo(product);
			productvo.setCategoryTitle(catTittle);	
			productVOs.add(productvo);
		}

		/*
		 * List<Category>
		 * catOfProductsFromDB=productsFromDB.stream().map(Product::getCategory).collect
		 * (Collectors.toList());
		 * 
		 * // List<String>
		 * categories=catOfProductsFromDB.stream().map((ProductcatOfProductsFromDB)
		 * List<ProductVO> productVo = productsFromDB.stream().map(product ->
		 * entityToVo(product)) .collect(Collectors.toList());
		 */
		
		return productVOs;
	}

	@Override
	public ProductVO getProductById(Long id) {
		Product productFromDB = productRepo.findById(id).orElseThrow();

		LOGGER.info("productFromDB {}", productFromDB);

		Category catOfProductFromDB = productFromDB.getCategory();

		LOGGER.info("catOfProductFromDB {}", catOfProductFromDB);

		String catTittle = catOfProductFromDB.getCategoryTitle();

		ProductVO productvo = entityToVo(productFromDB);

		productvo.setCategoryTitle(catOfProductFromDB.getCategoryTitle());

		return productvo;
	}
	// Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

	@Override
	public void deleteProduct(Long id) {

		productRepo.deleteById(id);
	}

	private ProductVO entityToVo(Product products) {
		ProductVO productVo = new ProductVO();
		productVo.setId(products.getId());
		productVo.setTitle(products.getTitle());
		productVo.setPrice(products.getPrice());
		productVo.setShort_description(products.getShort_description());
		productVo.setQuantity(products.getQuantity());
		return productVo;

	}

	private Product voToEntity(ProductVO productVo) {
		Product product = new Product();
		product.setId(productVo.getId());
		product.setQuantity(productVo.getQuantity());
		product.setShort_description(productVo.getShort_description());
		product.setTitle(productVo.getTitle());
		product.setPrice(productVo.getPrice());

		return product;

	}

}
