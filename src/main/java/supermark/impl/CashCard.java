package supermark.impl;

import supermark.interfaces.Card;
import supermark.interfaces.Customer;
import supermark.interfaces.ShoppingCart;

public class CashCard  implements Card {
    private double point;

    public CashCard(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        // 如果这块下来剩下的钱比点数少，那么就抵扣掉需要付的剩下的钱
        if (totalCostAfterDiscount < point){
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        }else {
            // 否者就抵扣掉所有的点
            point = 0;
            return point;
        }
    }
}
