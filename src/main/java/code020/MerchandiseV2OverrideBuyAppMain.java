package code020;

import code020.supermarket.MerchandiseOverload;
import code020.supermarket.MerchandiseV2;

public class MerchandiseV2OverrideBuyAppMain {
    public static void main(String[] args) {
        MerchandiseOverload merchandiseOverload = new MerchandiseOverload();
        // 调用方法，完成对成员变量的操作
        merchandiseOverload.init("书桌", "DESK9572", 40, 999.9, 500);
        merchandiseOverload.buy();
        merchandiseOverload.describe();

        double cost = merchandiseOverload.buy(10);
        double costVIP = merchandiseOverload.buy(10, true);
        merchandiseOverload.describe();
    }

}
