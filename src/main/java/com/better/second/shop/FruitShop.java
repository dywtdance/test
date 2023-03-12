package com.better.first.shop;

import com.better.first.entity.Fruit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitShop {
    private Map<Fruit, BigDecimal> shop = new HashMap<>();

    /**
     * 加入草莓和苹果
     */
    public FruitShop() {
        shop.put(new Fruit("apple", new BigDecimal("8")), new BigDecimal("8"));
        shop.put(new Fruit("strawberry", new BigDecimal("13")), new BigDecimal("13"));
    }

    public void addFruit(String name, BigDecimal price) {
        shop.put(new Fruit(name, price), price);
    }

    public void removeFruit(String name, BigDecimal price) {
        shop.remove(new Fruit(name, price));
    }

    /**
     * 查询所有水果总类
     * @return
     */
    public Set<String> getAllFruitTypes() {
        Set<String> fruitTypes = new HashSet<>();
        for (Map.Entry<Fruit, BigDecimal> entry : shop.entrySet()) {
            fruitTypes.add(entry.getKey().getName());
        }
        return fruitTypes;
    }

    public BigDecimal getPrice(String name) {
        for (Map.Entry<Fruit, BigDecimal> entry : shop.entrySet()) {
            if (entry.getKey().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
