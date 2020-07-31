package com.kenyi.ecommerce.repository;

import com.kenyi.ecommerce.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Products, Long> {

    Products findByName(String name);
}
