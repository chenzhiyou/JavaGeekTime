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
}
