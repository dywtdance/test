package com.better.first;

import com.better.first.entity.FruitShop;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
 * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
 * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 *
 *
 * 分析思路：
 *  站在超市的角度看，首先水果的品质和价格是固定的而且一般是超市有什么水果才会标注什么水果出来，言下之意就是：具体的水果和价格是固定的。
 *  所以唯一的变量：客户需要买哪种水果和对应多少斤两
 */
public  class Practise {
    public static void main(String[] args) {
        FruitShop fruitShop = new FruitShop();
        Map<String, Integer> items = new HashMap<>();
        items.put("apple", 2);
        items.put("strawberry", 3);
        double totalPrice = fruitShop.calculateTotalPrice(items);
        System.out.println("总价为: " + totalPrice);
    }
}
