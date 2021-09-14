package code020;

import code020.supermarket.LittleSupperMarket;
import code020.supermarket.Merchandise;
import code020.supermarket.MerchandiseV2;
import code020.supermarket.PhoneExtendsMerchandiseV2;

public class InstanceOfTestAppMain {
    public static void main(String[] args) {
        int merchandiseCount = 600;
        LittleSupperMarket supperMarket = new LittleSupperMarket();
        supperMarket.init("大卖场","世纪大道", 500, 100,100);
        for (int i = 0;i < merchandiseCount;i++){
            MerchandiseV2 m = new MerchandiseV2();
            if (m instanceof PhoneExtendsMerchandiseV2){
                PhoneExtendsMerchandiseV2 phoneExtendsMerchandiseV2 = (PhoneExtendsMerchandiseV2)m;
                System.out.println(phoneExtendsMerchandiseV2.calculateProfit());
            }
        }
    }
}
