package supermark.impl;

import supermark.interfaces.Category;
import supermark.interfaces.Merchandise;

public class SimpleMerchandise implements Merchandise {
    private String name;
    private double soldPrice;
    private double purchasePrice;
    private int count;
    private Category category;

    public SimpleMerchandise(String name, double soldPrice, double purchasePrice,
                             int count, Category category) {
        this.name = name;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        this.count = count;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSoldPrice() {
        return soldPrice;
    }

    @Override
    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public int buy(int count) {
        //TODO:卖超了怎么办？
        this.count -= count;
        return count;
    }

    @Override
    public void putBack(int count) {
        this.count += count;

    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
