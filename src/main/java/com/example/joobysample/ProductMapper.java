package com.example.joobysample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;

public class ProductMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode toJson(Product product) {
        var node = objectMapper.createObjectNode();
        node.put("id", product.id());
        node.put("name", product.name());
        return node;
    }

    public static JsonNode toJson(List<Product> products) {
        return products
                .stream()
                .map(ProductMapper::toJson)
                .collect(objectMapper::createArrayNode, ArrayNode::add, ArrayNode::addAll);
    }
}
