package code020;

import code020.person.Customer;
import code020.supermarket.LittleSupperMarket;
import code020.supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSuperMarketSecodHalfPriceAppMain {
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

        while (open){
            System.out.println("本店叫做" + littleSupperMarket.superMarketName);
            System.out.println("本店地址" + littleSupperMarket.address);
            System.out.println("共有车位" + littleSupperMarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSupperMarket.incomingSum);
            System.out.println("共有产品" + littleSupperMarket.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" +((int)(Math.random()* 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;
            System.out.println("顾客带了" + customer.money + "元");

            if (customer.isDrivingCar){
                if (littleSupperMarket.parkingCount > 0){
                    littleSupperMarket.parkingCount--;
                    System.out.println("欢迎"+ customer.name+ "驾车而来。本店已经为您安排了车位" +
                            "免费停车哦，车位编号为"+ littleSupperMarket.parkingCount);
                }else{
                    System.out.println("不好意思，本店车位已满，欢迎您下次光临");
                    continue;
                }
            }else {
                System.out.println("欢迎"+ customer.name + "光临本店");
            }

            double totalCost = 0;

            while (true){
                System.out.println("今日超市大特惠，所有商品第二件半价！选择要购买的商品索引");
                int index = scanner.nextInt();
                if (index < 0){
                    System.out.println("欢迎下次再来");
                    break;
                }

                double price = littleSupperMarket.merchandises[index].purchasePrice;
                System.out.println("商品单价为" + price);

                System.out.println("请输入要购买的数量:");
                int count = scanner.nextInt();

                if (littleSupperMarket.merchandises[index].count <count){
                    System.out.println("商品库存不足");
                    continue;
                }

                int fullPriceCount = count/2 +count %2;
                int halfPriceCount = count -fullPriceCount;
                totalCost = price * fullPriceCount + halfPriceCount *price/2;

                littleSupperMarket.merchandises[index].count -= count;

                System.out.println("商品总价为:" + totalCost);

                }
        }

    }
}
