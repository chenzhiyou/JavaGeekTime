package supermark.impl;

import supermark.interfaces.Card;
import supermark.interfaces.Category;
import supermark.interfaces.HashCard;
import supermark.interfaces.Merchandise;

public class ThinkAndBuyCustomer extends AbsCustomer implements HashCard {
    private Card card = VIPCard.Level0;

    public ThinkAndBuyCustomer(Category shouldBuy, String custId) {
        super(shouldBuy, custId);
    }


    @Override
    public int buyMerchandise(Merchandise merchandise) {
        Category category = merchandise.getCategory();
        // 有需要就买一个
        if (category == getShouldBuy()){
            return 1;
        }
        double soldPrice = merchandise.getSoldPrice();
        double avgPrice = (category.getHigherPrice()+ category.getLowerPrice())/2;
        if (soldPrice < avgPrice){
            return 1;
        }else {
            return 0;
        }
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return null;
    }

    @Override
    public double getMoneySpent() {
        return 0;
    }


}
