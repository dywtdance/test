package com.better.second;

import com.better.second.entity.FruitShop;

import java.util.HashMap;
import java.util.Map;

/**
 * 超市增加了一种水果芒果，其定价为 20 元/斤。
 * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 */
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
