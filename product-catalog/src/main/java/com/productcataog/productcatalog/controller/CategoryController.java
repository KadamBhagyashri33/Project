package com.productcataog.productcatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productcataog.productcatalog.model.Category;
import com.productcataog.productcatalog.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository catrepo;

	@PostMapping("/cat")
	public Category addCategory(@RequestBody Category category) {
		return catrepo.save(category);
	}

	@GetMapping("/cat")
	public List<Category> allCategory() {
		return catrepo.findAll();
	}

	// @GetMapping("/catbytemplatename") ...... pass template name as string
	// parameter

	@GetMapping(value = "/cat", params = "categoryTitle")
	@ResponseBody
	public Category getByCatTitle(@RequestParam("categoryTitle") String catTitle) {
		return catrepo.findByCategoryTitle(catTitle);

	}

	@GetMapping(value = "/cat/{String}")
	@ResponseBody
	public Category getByCatTitle2(String categoryTitle) {
		return catrepo.findByCategoryTitle(categoryTitle);

	}

}