package com.nimap_info.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap_info.crud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
