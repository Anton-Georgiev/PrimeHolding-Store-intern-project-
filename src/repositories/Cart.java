package repositories;

import models.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements CartRepository<Product> {
    Map<Product, Double> cart;

    public Cart() {
        cart = new LinkedHashMap<>();
    }

    @Override
    public Map<Product, Double> getCollection() {
        return cart;
    }

    @Override
    public void add(Product entity, Double quantity) {
        cart.put(entity, quantity);
    }

}
