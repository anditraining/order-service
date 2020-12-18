package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
