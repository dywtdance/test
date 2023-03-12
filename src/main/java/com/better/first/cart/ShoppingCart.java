package com.better.first.cart;

import com.better.first.entity.Fruit;
import com.better.first.shop.FruitShop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Fruit, Integer> items = new HashMap<>();
    private FruitShop fruitShop;

    public ShoppingCart(FruitShop fruitShop) {
        this.fruitShop = fruitShop;
    }

    public void addItem(String name, int amount) {
        BigDecimal price = fruitShop.getPrice(name);
        if (price == null) {
            throw new IllegalArgumentException("没有这个水果");
        }
        Fruit fruit = new Fruit(name, price);
        int originalAmount = items.getOrDefault(fruit, 0);
        items.put(fruit, originalAmount + amount);
    }

    public void removeItem(String name, int amount) {
        BigDecimal price = fruitShop.getPrice(name);
        if (price == null) {
            throw new IllegalArgumentException("没有这个水果");
        }
        Fruit fruit = new Fruit(name, price);
        int originalAmount = items.getOrDefault(fruit, 0);
        if (originalAmount < amount) {
            throw new IllegalArgumentException("请检查数量");
        } else if (originalAmount == amount) {
            items.remove(fruit);
        } else {
            items.put(fruit, originalAmount - amount);
        }
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Fruit, Integer> entry : items.entrySet()) {
            BigDecimal price = entry.getKey().getPrice();
            int amount = entry.getValue();
            totalPrice = totalPrice.add(price.multiply(new BigDecimal(amount)));
        }
        return totalPrice;
    }
}
