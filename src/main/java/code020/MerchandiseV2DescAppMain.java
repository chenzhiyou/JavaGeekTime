package code020;

import code020.supermarket.MerchandiseV2;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandiseV2 = new MerchandiseV2();
        // 调用方法，完成对成员变量的操作
        merchandiseV2.init("书桌", "DESK9572", 40, 999.9, 500);
        merchandiseV2.describe();
    }

}
