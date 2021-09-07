package code020;

import code020.person.Customer;
import code020.supermarket.LittleSupperMarket;
import code020.supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSuperMarketThisAppMain {
    public static void main(String[] args) {
        LittleSupperMarket littleSupperMarket = new LittleSupperMarket();
        littleSupperMarket.address = "世纪大道666号";
        littleSupperMarket.superMarketName = "有家超市";
        littleSupperMarket.parkingCount = 200;
        littleSupperMarket.merchandises = new Merchandise[200];
        littleSupperMarket.merchandiseSold = new int[littleSupperMarket.merchandises.length];

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

        System.out.println("超市开门啦！");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);


            System.out.println("本店叫做" + littleSupperMarket.superMarketName);
            System.out.println("本店地址" + littleSupperMarket.address);
            System.out.println("共有车位" + littleSupperMarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSupperMarket.incomingSum);
            System.out.println("共有产品" + littleSupperMarket.merchandises.length + "种");

            System.out.println("littleSupperMarket的对象是" +littleSupperMarket);
            System.out.println("下面请利润最高的商品自我介绍：");
            Merchandise m = littleSupperMarket.getBiggerstProfitMerchandise();
            m.describe();
            System.out.println("利润最高的Merchandise的对象是" + m);
            if (!m.hasEnoughCountFor(500)){
                System.out.println("补充库存");
            }
    }
}
