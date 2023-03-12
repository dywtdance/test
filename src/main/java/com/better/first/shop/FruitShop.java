package com.better.first.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private Map<String, Fruit> fruits;

    public FruitShop() {
        fruits = new HashMap<>();
        fruits.put("apple", new Apple(8.0));
        fruits.put("strawberry", new Strawberry(13.0));
    }

    public void addFruit(String name, double price) {
        fruits.put(name, new Fruit(name, price) {
            @Override
            public double calculatePrice(int weight) {
                return weight * getPrice();
            }
        });
    }

    public void setPrice(String name, double price) {
        fruits.get(name.toLowerCase()).setPrice(price);
    }

    public Fruit getFruit(String name) {
        return fruits.get(name.toLowerCase());
    }
}
