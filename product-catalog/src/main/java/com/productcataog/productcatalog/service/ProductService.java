package com.productcataog.productcatalog.service;

import java.util.List;

import com.productcataog.productcatalog.model.Category;
import com.productcataog.productcatalog.model.Product;
import com.productcataog.productcatalog.vo.ProductVO;

public interface ProductService {

//  public Product addProduct(Product productVo,String cat);

	public ProductVO addProduct(ProductVO productVo);

	public List<ProductVO> getAllProducts();

	public ProductVO getProductById(Long id);

	public void deleteProduct(Long id);

//	public List<ProductVO> findAllProductsByCategory(Long id);

//	public List<ProductVO> findAllProductsBytitle(String Title);

}
