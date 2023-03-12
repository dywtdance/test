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
        //客户D获取水果类型
        //客户就问那我想知道有什么水果
        Set<String> allFruitTypes = fruitShop.getAllFruitTypes();
        for (String fruit : allFruitTypes) {
            System.out.println("水果："+ fruit + "，价格：" + fruitShop.getPrice(fruit));
        }
        //添加进购物车
        ShoppingCart cart = new ShoppingCart(fruitShop);
        cart.addItem("apple",3);
        cart.addItem("strawberry",4);
        cart.addItem("mango",2);

        //店家给草莓打折0.8
        Coupon coupon = new Coupon();
        coupon.setType(Coupon.Type.DISCOUNT_FOR_ITEM);
        coupon.setDiscountItem("strawberry");
        coupon.setDiscount(new BigDecimal("0.8"));
        //满100即减10
        Coupon coupon1 = new Coupon();
        coupon1.setType(Coupon.Type.REDUCE);
        coupon1.setMinPrice(new BigDecimal("100"));
        coupon1.setSubPrice(new BigDecimal("10"));
       List<Coupon> couponList = new ArrayList<>();
       couponList.add(coupon);
       couponList.add(coupon1);
        Order order = new Order(cart, couponList);
        order.calculateTotal();
        String orderInfo = order.getOrderInfo();
        System.out.println(orderInfo);

    }
}
