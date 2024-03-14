package com.javatechie.query.demo.repository;

import com.javatechie.query.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<Product, Long> {
}
