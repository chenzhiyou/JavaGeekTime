package code020;

import code020.supermarket.LittleSupperMarket;
import code020.supermarket.Merchandise;

public class RunLittleSuperMarketAppMain {
    public static void main(String[] args) {
        LittleSupperMarket littleSupperMarket = new LittleSupperMarket();
        littleSupperMarket.address = "世纪大道666号";
        littleSupperMarket.superMarketName = "有家超市";
        littleSupperMarket.parkingCount = 200;
        littleSupperMarket.merchandises = new Merchandise[200];
        littleSupperMarket.merchandiseSold = new int[littleSupperMarket.merchandiseSold.length];

        Merchandise[] all = littleSupperMarket.merchandises;

        for (int i =0; i< all.length; i++){
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * 200;

            all[i] = m;
        }
    }
}
