package supermark.interfaces;

public interface Customer {
    /**
     * 开始购物前准备
     */
    void startShopping();

    String getCustId();

    /**
     * 顾客想要购买商品的种类
     * @return
     */
    Category chooseCategory();

    /**
     * 顾客是否购买此商品
     * @param merchandise 判断是否要购买的商品
     * @return 购买多少个
     */
    int buyMerchandise(Merchandise merchandise);

    /**
     * 顾客是否买够了，要结账
     * @return true：要结账， false： 继续逛
     */
    boolean wantToCheckout();

    /**
     *
     * @param shoppingCart 此次购买的商品的购物车
     * @param totalCost 经过超市折扣策略后的折后总价
     * @return 支付成功返回支付的钱 否则返回-1
     */
    double payFor(ShoppingCart shoppingCart, double totalCost);

    /**
     *
     * @return 顾客花的钱
     */
    double getMoneySpent();
}
