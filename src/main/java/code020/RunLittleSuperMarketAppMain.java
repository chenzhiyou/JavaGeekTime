package code020;

import code020.person.Customer;
import code020.supermarket.LittleSupperMarket;
import code020.supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSuperMarketAppMain {
    public static void main(String[] args) {
        // String superMarketName, String address, int parkingCount,
        //                     int merchandiseCount, int count
        LittleSupperMarket littleSupperMarket = new LittleSupperMarket();
        littleSupperMarket.init("有家超市",
                "世纪大道666号", 200, 200, 200);
//        littleSupperMarket.address = "世纪大道666号";
//        littleSupperMarket.superMarketName = "有家超市";
//        littleSupperMarket.parkingCount = 200;
//        littleSupperMarket.merchandises = new Merchandise[200];
//        littleSupperMarket.merchandiseSold = new int[littleSupperMarket.merchandises.length];
//
//        Merchandise[] all = littleSupperMarket.merchandises;

//        for (int i =0; i< all.length; i++){
//            Merchandise m = new Merchandise();
//            m.count = 200;
//            m.id = "ID" + i;
//            m.name = "商品" + i;
//            m.purchasePrice = Math.random() * 200;
//            m.soldPrice = (1 + Math.random()) * 200;
//
//            all[i] = m;
//        }

        System.out.println("超市开门啦！");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);

        while (open) {
            System.out.println("本店叫做" + littleSupperMarket.superMarketName);
            System.out.println("本店地址" + littleSupperMarket.address);
            System.out.println("共有车位" + littleSupperMarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSupperMarket.incomingSum);
            System.out.println("共有产品" + littleSupperMarket.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;
            System.out.println("顾客带了" + customer.money + "元");

            if (customer.isDrivingCar) {
                if (littleSupperMarket.parkingCount > 0) {
                    littleSupperMarket.parkingCount--;
                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为您安排了车位" +
                            "免费停车哦，车位编号为" + littleSupperMarket.parkingCount);
                } else {
                    System.out.println("不好意思，本店车位已满，欢迎您下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            double totalCost = 0;

//            while (true){
//                System.out.println("本店提供" + .length + "种商品，欢迎选购。请输入商品编号：");
//                int index = scanner.nextInt();
//                if(index < 0){
//                    break;
//                }
//
//                if(index >= all.length){
//                    System.out.println("本店没有这种商品，请输入编号在0到" + (all.length - 1) +"之内的商品编号。");
//                    continue;
//                }
//
//                Merchandise m = all[index];
//                System.out.println("您选购的商品名字"+ m.name + ". 单价是" + m.soldPrice + "请输入要购买的数量");
//                m.describe();
//                int numToBuy = scanner.nextInt();
//                if (numToBuy <=0 ){
//                    System.out.println("不买看看也好，欢迎继续挑选");
//                    continue;
//                }
//                totalCost += numToBuy * m.soldPrice;
//                if (totalCost > customer.money){
//                    System.out.println("您带的钱不够，欢迎继续挑选");
//                    continue;
//                }
//
//                System.out.println(totalCost);
//                m.count -= numToBuy;
//                littleSupperMarket.merchandiseSold[index] += numToBuy;
//
//            }
//
//            customer.money -= totalCost;
//            if (customer.isDrivingCar){
//                littleSupperMarket.parkingCount++;
//            }
//            System.out.println("顾客"+customer.name +"共消费了" + totalCost );
//            littleSupperMarket.incomingSum = totalCost;
//
//            System.out.println("还继续营业吗");
//            open = scanner.nextBoolean();
//        }
//
//        System.out.println("超市关门了");
//        System.out.println("今天总营业额为" +littleSupperMarket.incomingSum + "营业情况如下：");
//
//        for (int i=0; i < littleSupperMarket.merchandiseSold.length; i++){
//            Merchandise m = all[i];
//            int numSold = littleSupperMarket.merchandiseSold[i];
//            if (numSold >0){
//                double incomming = m.soldPrice *numSold;
//                double netIncomming = (m.soldPrice - m.purchasePrice)* numSold;
//                System.out.println(m.name + "售出了" + numSold + "个，销售额为" + incomming
//                + ".净利润为" + netIncomming);
//            }
//        }
//
//        for (int i =0; i<all.length; i++){
//            Merchandise m = new Merchandise();
//            m.name = "商品" + i;
//            m.count = 200;
//            m.purchasePrice = Math.random()*200;
//            m.soldPrice = m.purchasePrice*(1+Math.random());
//            m.id = "ID" + i;
//            all[i]= m;
//        }

            System.out.println("下面请利润最高的商品自我介绍：");
            littleSupperMarket.getBiggerstProfitMerchandise().describe();
        }
    }
}