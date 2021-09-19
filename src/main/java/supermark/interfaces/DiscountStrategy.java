package supermark.interfaces;

public interface DiscountStrategy {
    // TODO:某一个种类的商品，满多少减多少
    // TODO:某一个种类的商品，第二件半价
    /**
     *
     * @param shoppingCart
     * @return 因为此这款策略所折扣的钱，注意并非折扣的总价
     */
    double discount(ShoppingCart shoppingCart);
}
