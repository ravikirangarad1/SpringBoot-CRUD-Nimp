package com.nimap_info.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nimap_info.crud.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
