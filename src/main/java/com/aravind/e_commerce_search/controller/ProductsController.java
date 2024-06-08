package com.aravind.e_commerce_search.controller;


import com.aravind.e_commerce_search.entity.Product;
import com.aravind.e_commerce_search.pojo.SearchProductApiData;
import com.aravind.e_commerce_search.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    @PostMapping("api/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestBody SearchProductApiData apiData){
        List<Product> productList = productRepository.dbSearchProducts(apiData.getSearchText());

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
