package com.example.joobysample;

import com.fasterxml.jackson.databind.JsonNode;
import io.jooby.Context;
import io.jooby.Jooby;

public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addRoutes(Jooby app) {
        app.get("/products", this::getAll);
    }

    private JsonNode getAll(Context ctx) {
        var products = productRepository.selectAll();
        return ProductMapper.toJson(products);
    }
}
