package com.javatechie.demo.repository;

import com.javatechie.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<Product, Long> {
}
