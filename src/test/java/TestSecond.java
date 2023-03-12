import com.better.second.cart.ShoppingCart;
import com.better.second.shop.FruitShop;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

public class TestSecond {
    @Test
    public void test() {
        //店家说刚到了一批芒果,卖20块
        FruitShop fruitShop = new FruitShop();
        fruitShop.addFruit("mango",new BigDecimal("20"));
        //客户就问那我想知道有什么水果
        Set<String> allFruitTypes = fruitShop.getAllFruitTypes();
        for (String fruit : allFruitTypes) {
            System.out.println("水果："+ fruit + "，价格：" + fruitShop.getPrice(fruit));
        }
        //客人说那芒果1斤 草莓2斤 苹果3斤
        ShoppingCart cart = new ShoppingCart(fruitShop);
        cart.addItem("apple",3);
        cart.addItem("strawberry",2);
        cart.addItem("mango",1);
        System.out.println("总价格：" + cart.getTotalPrice());
    }
}
