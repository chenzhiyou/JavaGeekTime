package code020.supermarket;

import java.util.Objects;

public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public  double purchasePrice;

    public static double DISCOUNT_FOR_VIP = 0.95;

    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
    }

    public static double getVIPDiscount(){
        return DISCOUNT_FOR_VIP;
    }

    public static double getDiscountOnDiscount(LittleSupperMarket littleSupperMarket){
        double activityDiscount = littleSupperMarket.parkingCount;
        return DISCOUNT_FOR_VIP * activityDiscount;

    }

    public void init(String name, String id, int count, double soldPrice, double purchasePrice){
        if(soldPrice <0 ){

        }
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public void describe(){
        System.out.println("商品的名字叫做"+ name+ "。id是" + id +".商品的单价是" + soldPrice
        + ".销售一个的毛利润是" + (soldPrice- purchasePrice));
    }



    public double calculateProfit(){
        double profit = soldPrice - purchasePrice;
        if (profit <=0){
            // 这个return是代码块里的return，是return所在代码块的最后一个语句
            return 0;
        }
        // 一个方法可以有多个返回语句
        return profit;
    }

//    public boolean equals(Object o){
//        if (this == o){
//            return true;
//        }
//        if (!(o instanceof MerchandiseV2)){
//            return false;
//        }
//        MerchandiseV2 that = (MerchandiseV2) o;
//        return getCurrentCount() == that.getCurrentCount();
//    }


    @Override
    public String toString() {
        return "MerchandiseV2{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", count=" + count +
                ", soldPrice=" + soldPrice +
                ", purchasePrice=" + purchasePrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MerchandiseV2)) return false;
        MerchandiseV2 that = (MerchandiseV2) o;
        return count == that.count &&
                Double.compare(that.soldPrice, soldPrice) == 0 &&
                Double.compare(that.purchasePrice, purchasePrice) == 0 &&
                name.equals(that.name) &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, count, soldPrice, purchasePrice);
    }

    public double getCurrentCount(){
        return count;
    }

    public int getIntSoldPrice(){
        return (int)soldPrice;
    }


    public double buy(int countToBuy){
        if (count < countToBuy){
            System.out.println("商品库存不足");
            return -1;
        }

        System.out.println("商品单价为"+ purchasePrice);

        int fullPriceCount = countToBuy/2 +countToBuy %2;
        int halfPriceCount = countToBuy -fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount *purchasePrice/2;

        count -= countToBuy;

        return totalCost;
    }

    public double buyAndPrintLeft(int countToBuy, boolean printLeft){
        if (count < countToBuy){
            System.out.println("商品库存不足");
            if (printLeft){
                System.out.println("商品剩余库存为:" + count);
            }
            return -1;
        }

        System.out.println("商品单价为"+ purchasePrice);

        int fullPriceCount = countToBuy/2 +countToBuy %2;
        int halfPriceCount = countToBuy -fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount *purchasePrice/2;

        count -= countToBuy;
        if (printLeft){
            System.out.println("剩余库存为："+ count);
        }
        return totalCost;
    }

    public boolean totalValueBiggerThan(MerchandiseV2 merchandise){
        return count * purchasePrice > merchandise.purchasePrice * merchandise.count;
    }


    public boolean isTheBiggestTotalValueOne(LittleSupperMarket littleSupperMarket){
        double totalValue = count * purchasePrice;
        for (int i = 0; i< littleSupperMarket.merchandises.length; i++){
            MerchandiseV2 m = littleSupperMarket.merchandises[i];
            double newTotalValue = m.purchasePrice * m.count;
            if (totalValue < newTotalValue){
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中
                return false;
            }
        }
        return true;
    }


    public void duplicateName(int count){
        this.count = 999;
        count = 999;
    }
    /*
    方法里隐藏着一个this自引用，指向调用这个方法的对象
    使用一个对象调用方法，也叫做在这个对象上调用方法。因为方法可以访问这个对象的值
    访问一个成员变量的完整形态，是"this.成员变量的名字"
     */
    public void addCount(int count){
        this.count += count;
        System.out.println("Merchandise的addCount方法使用的对象是"+ this);
    }

    public boolean hasEnoughCountFor(int count){
        System.out.println("Merchandise的hasEnoughCountFor方法使用的对象是"+ this);
        return this.count >= count;
    }


}
