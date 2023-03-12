package com.better.third.shop;

import com.better.third.entity.Fruit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitShop {
    private Map<Fruit, BigDecimal> fruits = new HashMap<>();

    public FruitShop() {
        fruits.put(new Fruit("apple", new BigDecimal("8")), new BigDecimal("8"));
        fruits.put(new Fruit("strawberry", new BigDecimal("13"),new BigDecimal("0.8")), new BigDecimal("13"));
        fruits.put(new Fruit("mango", new BigDecimal("20")), new BigDecimal("20"));
    }


    public void addFruit(String name, BigDecimal price) {
        fruits.put(new Fruit(name, price), price);
    }

    public void removeFruit(String name, BigDecimal price) {
        fruits.remove(new Fruit(name, price));
    }

    /**
     * 查询所有水果总类
     * @return
     */
    public Set<String> getAllFruitTypes() {
        Set<String> fruitTypes = new HashSet<>();
        for (Map.Entry<Fruit, BigDecimal> entry : fruits.entrySet()) {
            fruitTypes.add(entry.getKey().getName());
        }
        return fruitTypes;
    }

    public BigDecimal getPrice(String name) {
        for (Map.Entry<Fruit, BigDecimal> entry : fruits.entrySet()) {
            Fruit fruit = entry.getKey();
            if (fruit.getName().equals(name)) {
                return  fruit.getPrice().multiply(fruit.getDiscount());
            }
        }
        return null;
    }
}
