package com.better.fourth.order;

import com.better.fourth.cart.ShoppingCart;
import com.better.fourth.coupon.Coupon;
import com.better.fourth.entity.Fruit;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order {
    /**
     * 购物车
     */
    private ShoppingCart shoppingCart;
    /**
     * 优惠券
     */
    private List<Coupon> couponList;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 总价
     */
    private BigDecimal totalPrice = BigDecimal.ZERO;;


    public Order(ShoppingCart shoppingCart,List<Coupon> couponList) {
        this.couponList= couponList;
        this.shoppingCart = shoppingCart;
        this.createTime= new Date();
    }
    public BigDecimal calculateTotal() {
        //总优惠价格
        BigDecimal discountTotal = BigDecimal.ZERO;
        //根据购物车中所有的产品和单价相乘
        totalPrice  = shoppingCart.getTotalPrice();

        Map<Fruit, Integer> carts = shoppingCart.getItems();
        //获取所有指定商品打折的优惠价格
        for (Coupon coupon : couponList) {
            if(coupon.getType() == Coupon.Type.DISCOUNT_FOR_ITEM) {
                for(Map.Entry<Fruit,Integer>  entry:carts.entrySet()) {
                    Fruit fruit = entry.getKey();
                    BigDecimal amount = new BigDecimal(entry.getValue());
                    if(fruit.getName().equals(coupon.getDiscountItem())){
                        BigDecimal itemDiscount = fruit.getPrice().multiply(BigDecimal.ONE.subtract(coupon.getDiscount()));
                        discountTotal = discountTotal.add(amount.multiply(itemDiscount));
                    }
                }
            }
        }
        totalPrice = totalPrice.subtract(discountTotal);

        //根据满减类型进行计算
        //先给满减价格排序
        List<Coupon> list = couponList.stream().filter(coupon -> coupon.getType() == Coupon.Type.REDUCE)
                .sorted((Comparator.comparing(Coupon::getMinPrice)).reversed()).toList();
        for (Coupon coupon : list) {
            //大于等于最大金额
            if (totalPrice.compareTo(coupon.getMinPrice()) >= 0) {
                totalPrice = totalPrice.subtract(coupon.getSubPrice());
            }
        }
        return totalPrice;
    }

    public String getOrderInfo() {
        StringBuilder stringBuilder = new StringBuilder("订单信息：{ 订单时间：");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimeStr = sdf.format(createTime);
        stringBuilder.append(createTimeStr);
        stringBuilder.append(", 优惠后总价为：");
        stringBuilder.append(totalPrice).append(" }。");
        return stringBuilder.toString();
    }
}
