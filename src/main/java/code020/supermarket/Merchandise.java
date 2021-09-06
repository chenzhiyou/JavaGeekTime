package code020.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public  double purchasePrice;

    /*
    访问修饰符
    返回值类型：无需返回值则用void表示，void是Java中的关键字
    方法名：任意合法的标识符都可以
    参数列表：后续讲解
    方法体：方法的代码
    方法体内部定义的变量叫做局部变量
     */
    public void describe(){
        System.out.println("商品的名字叫做"+ name+ "。id是" + id +".商品的单价是" + soldPrice
        + ".销售一个的毛利润是" + (soldPrice- purchasePrice));
    }

    /*
    让商品自己计算利润的方法
    让超市找出利润最高的商品的方法
    商品的其他方法
    方法调用调试之step into：进入被调用的方法内部继续调试
     */

    /*
    在方法定义中指定方法的返回值类型
    Java中一个方法只能有一种返回值，如果不需要返回值则用void表示
    如果定义了返回值，则必须使用return语句返回方法的返回值，return是Java的关键字
    可以认为，返回值必须要能够用来给返回值类型的变量赋值
     */

    public double calculateProfit(){
        double profit = soldPrice - purchasePrice;
        if (profit <=0){
            // 这个return是代码块里的return，是return所在代码块的最后一个语句
            return 0;
        }
        // 一个方法可以有多个返回语句
        return profit;
    }

    // 返回值如果是解百纳类型，则要类型完全相同，或者符合类型自动转换规则
    public double getCurrentCount(){
        return count;
    }

    // 如果不符合规则，可以适应强制类型转换
    public int getIntSoldPrice(){
        return (int)soldPrice;
    }

    /*
    参数是定义在方法名字后面的括号里的
    参数定义的规范和变量一样，都是类型名字加标识符，这里的标识符我们叫做参数名
    方法体重的代码可以使用参数
    参数的值在调用方法的时候需要给出，有的资料叫实参（实际参数）
    对应的，方法定义这里的参数，叫做形参（形式参数）
     */

    public double buy(int countToBuy){
        if (count < countToBuy){
            // 如果返回值是复数，就代表库存不足，购买失败
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

    // 一个方法可以有多个参数，多个参数直接用逗号隔开
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

    // 参数可以是任意类型，包括自定义类型，甚至是自己的类型都没有问题
    public boolean totalValueBiggerThan(Merchandise merchandise){
        return count * purchasePrice > merchandise.purchasePrice * merchandise.count;
    }

    // 参数可以是任何类型，包括自定义类型
    // 求是否是售价最高的商品
    public boolean isTheBiggestTotalValueOne(LittleSupperMarket littleSupperMarket){
        double totalValue = count * purchasePrice;
        for (int i = 0; i< littleSupperMarket.merchandises.length; i++){
            Merchandise m = littleSupperMarket.merchandises[i];
            double newTotalValue = m.purchasePrice * m.count;
            if (totalValue < newTotalValue){
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中
                return false;
            }
        }
        return true;
    }
}
