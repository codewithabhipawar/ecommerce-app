package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable String productId)
	{
		return ResponseEntity.ok(productService.getProductByPId(productId));
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Product>> getSingleProductByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(productService.getProductByUserId(userId));
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
	{
		 return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
	}

}
