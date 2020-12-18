package com.javatpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Product;
import com.javatpoint.service.ProductService;

@RestController
public class OrderController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/order")
	private Product saveBook(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product;
	}
	
	@GetMapping("/order/{productId}")
	private Product getBook(@PathVariable("productId") int productId) {
		return productService.getProductById(productId);
	}

}
