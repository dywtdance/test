import com.better.fourth.cart.ShoppingCart;
import com.better.fourth.coupon.Coupon;
import com.better.fourth.order.Order;
import com.better.fourth.shop.FruitShop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestFourth {
    @Test
    public void test() {
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("orange",new BigDecimal("15"));
        //客户D获取水果类型
        //客户就问那我想知道有什么水果
        Set<String> allFruitTypes = fruitShop.getAllFruitTypes();
        for (String fruit : allFruitTypes) {
            System.out.println("水果："+ fruit + "，价格：" + fruitShop.getPrice(fruit));
        }
        //添加进购物车
        ShoppingCart cart = new ShoppingCart(fruitShop);
//        cart.addItem("apple",5); //
        cart.addItem("strawberry",8);
//        cart.addItem("mango",4);
//        cart.addItem("orange",4);

        //店家给草莓打折0.8
        Coupon discountCoupon = new Coupon();
        discountCoupon.setType(Coupon.Type.DISCOUNT_FOR_ITEM);
        discountCoupon.setDiscountItem("strawberry");
        discountCoupon.setDiscount(new BigDecimal("0.8"));
        //满100即减10
        Coupon reduceCoupon1 = new Coupon();
        reduceCoupon1.setType(Coupon.Type.REDUCE);
        reduceCoupon1.setMinPrice(new BigDecimal("100"));
        reduceCoupon1.setSubPrice(new BigDecimal("10"));
        //满200减30
        Coupon reduceCoupon2 = new Coupon();
        reduceCoupon2.setType(Coupon.Type.REDUCE);
        reduceCoupon2.setMinPrice(new BigDecimal("200"));
        reduceCoupon2.setSubPrice(new BigDecimal("30"));
        List<Coupon> couponList = new ArrayList<>();
       couponList.add(discountCoupon);
       couponList.add(reduceCoupon1);
       couponList.add(reduceCoupon2);
        Order order = new Order(cart, couponList);
        order.calculateTotal();
        String orderInfo = order.getOrderInfo();
        System.out.println(orderInfo);

    }
}
