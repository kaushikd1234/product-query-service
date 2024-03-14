package com.javatechie.demo.service;

import com.javatechie.demo.dto.ProductEvent;
import com.javatechie.demo.entity.Product;
import com.javatechie.demo.repository.ProductQueryRepository;
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
        // process of UpdateProduct events emitted from the Producer
        if ("UpdateProduct".equals(productEvent.getEventType())) {
            Product existingProduct = repository.findById(product.getId()).get();
            existingProduct.setPrice(product.getPrice());
            existingProduct.setName(product.getName());
            repository.save(existingProduct);
        }
    }
}
