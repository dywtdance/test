import com.better.third.cart.ShoppingCart;
import com.better.third.order.Order;
import com.better.third.shop.FruitShop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

public class TestThird {

    @Test
    public void test() {
        FruitShop fruitShop = new FruitShop();
        //客户C获取水果类型
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
        //订单结账
        Order order = new Order(cart);
        BigDecimal totalPrice = order.getTotalPrice();
        System.out.println("总价为：" + totalPrice);

    }
}
