package com.javatechie.query.demo.controller;

import com.javatechie.query.demo.entity.Product;
import com.javatechie.query.demo.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private ProductQueryService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();

    }
}
