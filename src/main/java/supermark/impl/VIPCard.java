package supermark.impl;

import supermark.interfaces.Card;
import supermark.interfaces.Customer;
import supermark.interfaces.ShoppingCart;

public enum VIPCard implements Card{
    Level0(1),
    level1(0.99),
    level2(0.95),
    level3(0.9),
    level4(0.85),
    level5(0.8);

    private double discount;
    VIPCard(double discount) {
        this.discount = discount;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        return totalCostAfterDiscount*(1-discount);
    }
}
