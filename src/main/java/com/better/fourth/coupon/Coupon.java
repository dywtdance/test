package com.better.fourth.coupon;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 优惠券类
 */
@Data
public class Coupon {
    public enum Type {
        REDUCE,
        DISCOUNT_FOR_ITEM
    }
    /**
     * 优惠券类型：订单满减 商品打折
     */
    private Type Type;
    /**
     * 打折率
     */
    private BigDecimal discount;
    /**
     * 最低消费金额
     */
    private BigDecimal minPrice;
    /**
     * 优惠金额
     */
    private BigDecimal subPrice;

    private String discountItem;

}
