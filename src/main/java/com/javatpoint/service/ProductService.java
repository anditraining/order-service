package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Product;
import com.javatpoint.repository.ProductRepository;

@Service
@EnableJms
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private static final String MESSAGE_QUEUE = "order_queue";

	public void saveOrUpdate(Product product) {
		repo.save(product);
		
		jmsTemplate.convertAndSend(MESSAGE_QUEUE, product);
	}

	public List<Product> getAllProduct() {
		List<Product> Product = new ArrayList<Product>();
		repo.findAll().forEach(Product1 -> Product.add(Product1));
		return Product;
	}

	public Product getProductById(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public void update(Product Product, int id) {
		repo.save(Product);
	}
}
