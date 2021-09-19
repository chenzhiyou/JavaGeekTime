package supermark.util;

import supermark.impl.*;
import supermark.interfaces.Category;
import supermark.interfaces.Customer;
import supermark.interfaces.Merchandise;
import supermark.interfaces.SuperMarket;

import java.util.Iterator;
import java.util.Scanner;

public class ShoppingUtil {
    private static final  Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }
    public  static void output(Object obj){
        System.out.println(String.valueOf(obj));
    }

    public static SuperMarket createSuperMarket(){
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];
        for (Category category :Category.values()){
            for (int i = 0; i< merchandisePerCategory; i++){
                double soldPrice = Math.random() * (category.getHigherPrice()-category.getLowerPrice())+ category.getLowerPrice();
                double purchasePrice = soldPrice * 0.7;
                all[category.ordinal()* merchandisePerCategory + i] = new SimpleMerchandise(category.name()+
                        i, soldPrice, purchasePrice, 200, category);
            }
        }
        SimpleSuperMarket superMarket = new SimpleSuperMarket(all);
        output("请输入超市的名字：");
        String s = input().next();
        if (s.trim().length()>0){
            superMarket.setName(s.trim());
        }
        return superMarket;
    }



    public static Category getRandomCategory(){
        return Category.values()[(int)(Math.random()*1000)% Category.values().length];
    }

    public static VIPCard getRandomVIPCard(){
        return VIPCard.values()[(int)(Math.random()*1000) %VIPCard.values().length];
    }

    public static Customer createCustomer(boolean auto){
        if (auto){
            String custId = "CUST"+ (int)(Math.random()*1000);
            Category shouldBuy = getRandomCategory();
            if (Math.random()<0.5){
                return new SuiYuanCustomer(shouldBuy, custId);
            }else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(shouldBuy, custId);
                return ret;
            }
        }
        // TODO 思考题：允许输入一个类名，使用class.forName(类名)，获得这个类class实例，然后调用newInstance方法，创建这个实例
        return null;
    }
}
