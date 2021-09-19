package supermark;

import supermark.impl.SimpleShopman;
import supermark.interfaces.Customer;
import supermark.interfaces.Shopman;
import supermark.interfaces.SuperMarket;

import static supermark.util.ShoppingUtil.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();
        Shopman shopman = new SimpleShopman(superMarket);
        boolean open = true;
        while (open){
            new  ShoppingTask(shopman).executeTask();
            output("是否继续营业？（YES）");
            open = ! input().next().trim().equalsIgnoreCase("no");
        }
        superMarket.dailyReport();
    }

}

class ShoppingTask{
    private Shopman shopman;
    public  ShoppingTask(Shopman shopman){
        this.shopman = shopman;
    }

    public void executeTask(){
        Customer customer = createCustomer(true);
        shopman.serveCustomer(customer);
    }
}
