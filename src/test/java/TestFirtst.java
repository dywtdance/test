import com.better.first.cart.ShoppingCart;
import com.better.first.shop.FruitShop;
import org.junit.Test;

import java.util.Set;

public class TestFirtst {
    @Test
    public void test() {
        FruitShop fruitShop = new FruitShop();
        ShoppingCart cart = new ShoppingCart(fruitShop);
        //客户问商店有什么水果 以及所有水果的价格
        Set<String> allFruitTypes = fruitShop.getAllFruitTypes();
        for (String fruit : allFruitTypes) {
            System.out.println("水果："+ fruit + "，价格：" + fruitShop.getPrice(fruit));
            //客人说各要2斤
            cart.addItem(fruit,2);
        }
        System.out.println("结账："+ cart.getTotalPrice());

    }
}
