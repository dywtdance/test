package com.better.fourth.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
 * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 */
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
    /**
     * 减免金额
     */
    private double discount;

    public FruitShop() {
        prices = new HashMap<>();
        prices.put("apple", APPLE_PRICE);
        prices.put("strawberry", STRAWBERRY_PRICE);
        prices.put("mango", MANGO_PRICE);
        discount = 0.0;
    }

    public double calculateTotalPrice(Map<String, Integer> items) {
        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            if (prices.containsKey(itemName)) {
                    double itemPrice = prices.get(itemName);
                    if (itemName.equals("strawberry")) {
                        itemPrice *= 0.8;
                    }
                    totalPrice += itemPrice * quantity;
            } else {
                throw new IllegalArgumentException("没有该水果: " + itemName);
            }
        }
        //满100减10
        if (totalPrice >= 100.0) {
            totalPrice -= 10.0; // 满 100 减 10
            System.out.println("满减10元");
        }
    /*    //每满100减10
        if (totalPrice >= 100.0) {
            discount = Math.floor(totalPrice / 100) * 10; // 计算满减的金额
        }
        totalPrice -= discount; // 减去满减的金额*/
        return totalPrice;
    }
}
