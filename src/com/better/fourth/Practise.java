package com.better.fourth;

import com.better.fourth.entity.FruitShop;

import java.util.HashMap;
import java.util.Map;

public class Practise {
    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        Map<String, Integer> items = new HashMap<>();
        items.put("apple", 2);
        items.put("strawberry", 3);
        items.put("mango", 3);
        double totalPrice = fruitShop.calculateTotalPrice(items);
        System.out.println("总价为: " + totalPrice);
    }
}
