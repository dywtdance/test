package com.better.first.entity;

import java.math.BigDecimal;

/**
 * 抽象水果类
 */
public abstract class Fruit {
    private String name;
    private BigDecimal price;

    public Fruit(String name,BigDecimal price) {
        this.name = name;
        this.price= price;
    }
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
