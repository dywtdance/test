package com.better.third.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 水果类
 */
public class Fruit {
    private String name;
    private BigDecimal price;

    private BigDecimal discount = BigDecimal.ONE;


    public Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public Fruit(String name, BigDecimal price,BigDecimal discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) &&
                Objects.equals(price, fruit.price) &&
                Objects.equals(discount,fruit.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price,discount);
    }

}
