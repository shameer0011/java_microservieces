package com.ProductServiece.ProductDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductServiece.ProductDemo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}