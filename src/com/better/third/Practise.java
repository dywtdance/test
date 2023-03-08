package com.better.third;

import com.better.third.entity.FruitShop;

import java.util.HashMap;
import java.util.Map;

/**
 * 超市做促销活动，草莓限时打 8 折。
 * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
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
