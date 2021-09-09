package code020;

import code020.supermarket.MerchandiseV2;
import code020.supermarket.MerchandiseV2WithConstructor;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
//        MerchandiseV2 merchandiseV2 = new MerchandiseV2();
//        // 调用方法，完成对成员变量的操作
//        merchandiseV2.init("书桌", "DESK9572", 40, 999.9, 500);
//        merchandiseV2.describe();
        MerchandiseV2WithConstructor merchandiseV2WithConstructor =
                new MerchandiseV2WithConstructor("书桌", "DESK9572", 40, 999.9, 500);
        merchandiseV2WithConstructor.describe();
    }

}
