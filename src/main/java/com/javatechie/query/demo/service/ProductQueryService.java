package com.javatechie.query.demo.service;

import com.javatechie.query.demo.entity.Product;
import com.javatechie.query.demo.repository.ProductQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {

    @Autowired
    private ProductQueryRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
