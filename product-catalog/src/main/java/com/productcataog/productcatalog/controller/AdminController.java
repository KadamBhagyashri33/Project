package com.productcataog.productcatalog.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productcataog.productcatalog.service.ProductService;
import com.productcataog.productcatalog.vo.ProductVO;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProductService productService;

	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(this.getClass());

	@GetMapping("/products")
	public List<ProductVO> getAllProducts() {

		return productService.getAllProducts();

	}

	@PostMapping("/products")
	public ProductVO addProducts(@RequestBody ProductVO productVo) {

		return productService.addProduct(productVo);

	}
	
	@GetMapping("/products/{id}")
	public ProductVO getAllProductById(@PathVariable("id")Long id) {

		return productService.getProductById(id);

	}
	@DeleteMapping("/products/{id}")
	public void  deleteProductById(@PathVariable("id")Long id) {

		productService.deleteProduct(id);

	}

}
