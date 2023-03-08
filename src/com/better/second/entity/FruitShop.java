package com.better.second.entity;

import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    /**
     * 苹果
     */
    private final double APPLE_PRICE = 8.0;
    /**
     * 草莓
     */
    private final double STRAWBERRY_PRICE = 13.0;
    /**
     * 芒果
     */
    private final double MANGO_PRICE = 20.0;
    private Map<String, Double> prices;

    public FruitShop() {
        prices = new HashMap<>();
        prices.put("apple", APPLE_PRICE);
        prices.put("strawberry", STRAWBERRY_PRICE);
        prices.put("mango", MANGO_PRICE);
    }

    public double calculateTotalPrice(Map<String, Integer> items) {
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            if (prices.containsKey(itemName)) {
                double itemPrice = prices.get(itemName);
                totalPrice += itemPrice * quantity;
            } else {
                throw new IllegalArgumentException("没有该水果: " + itemName);
            }
        }
        return totalPrice;
    }
}
