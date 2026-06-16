package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//get all products
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	//create product
	public Product createProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	//get product by product id
	public Product getProductByPId(String productId) throws ResourceNotFoundException
	{
		return productRepository
				.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with this given id: "+productId));
	}
	
	//get product by userId
	public List<Product> getProductByUserId(String userId) throws ResourceNotFoundException
	{
		return productRepository.findByUserId(userId);
	}
}
