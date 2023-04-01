package com.example.joobysample;

import java.util.List;

public class ProductRepository {

    private static final List<Product> products = List.of(
            new Product(1L, "product1"),
            new Product(2L, "product2"));

    public List<Product> selectAll() {
        return products;
    }
}
