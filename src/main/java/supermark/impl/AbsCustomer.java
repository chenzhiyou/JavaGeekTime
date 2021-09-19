package supermark.impl;

import supermark.interfaces.Category;
import supermark.interfaces.Customer;
import supermark.interfaces.ShoppingCart;

import static supermark.util.ShoppingUtil.getRandomCategory;

public abstract class AbsCustomer implements Customer {
    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft = 0;
    private int guangCount =0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(Category shouldBuy, String custId, int guangCount) {
        this.shouldBuy = shouldBuy;
        this.custId = custId;
        this.guangCount = guangCount;

    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public AbsCustomer(Category shouldBuy, String custId) {
        this.shouldBuy = shouldBuy;
        this.custId = custId;
    }

    public String getCustId(){
        return custId;
    }

    public void  startShopping(){
        guangLeft = guangCount;
    }

    public boolean wantToCheckout(){
        guangLeft --;
        return guangLeft <=0;
    }

    public double payFor(ShoppingCart shoppingCart, double totalCost){
        // TODO:买不起怎么办
        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy(){
        return shouldBuy;
    }

    public Category chooseCategory(){
        if (guangLeft +1 >= guangCount){
            return shouldBuy;
        }else {
            return getRandomCategory();
        }
    }

}
