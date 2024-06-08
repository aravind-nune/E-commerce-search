package com.aravind.e_commerce_search.repository;

import com.aravind.e_commerce_search.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Procedure(procedureName = "products_search")
    List<Product> dbSearchProducts(@Param("search_text") String searchText);

}
