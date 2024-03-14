package com.javatechie.query.demo.service;

import com.javatechie.query.demo.dto.ProductEvent;
import com.javatechie.query.demo.entity.Product;
import com.javatechie.query.demo.repository.ProductQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService {

    @Autowired
    private ProductQueryRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @KafkaListener(topics = "product-event-topic", groupId = "product-event-group")
    public void processProductEvents(ProductEvent productEvent) {
        Product product = productEvent.getProduct();

        if ("CreateProduct".equals(productEvent.getEventType())) {
            repository.save(product);
        }
    }
}
