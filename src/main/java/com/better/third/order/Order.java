package com.better.third.order;

import com.better.third.entity.Fruit;
import com.better.third.cart.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 订单类
 */
public class Order {
    private ShoppingCart shoppingCart;
    private BigDecimal totalPrice = new BigDecimal("0.0");

    public Order (ShoppingCart cart) {
        this.shoppingCart = cart;
    }

    public BigDecimal getTotalPrice() {
        if(shoppingCart == null) {
            throw new RuntimeException("请添加水果");
        }
        Map<Fruit, Integer> items = shoppingCart.getItems();
        for (Map.Entry<Fruit, Integer> entry : items.entrySet()) {
            Fruit fruit = entry.getKey();
            BigDecimal price = entry.getKey().getPrice();
            int amount = entry.getValue();
            totalPrice = totalPrice.add(price.multiply(new BigDecimal(amount).multiply(fruit.getDiscount())));
        }

        return totalPrice;
    }
}
