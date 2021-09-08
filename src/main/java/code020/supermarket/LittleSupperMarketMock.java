package code020.supermarket;

public class LittleSupperMarketMock {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    // 返回值类型可以是类名，这时候实际返回的值就是这个类的引用
    public Merchandise getBiggerstProfitMerchandise(LittleSupperMarketMock This){
        Merchandise curr = null;
        for (int i = 0; i<This.merchandises.length; i++){
            Merchandise m = This.merchandises[i];
            if (curr == null){
                curr = m;
                continue;
            }

            // 调用商品中定义的方法，不同的实例调用相同的方法，虽然代码相同，但是每个实例内部的数据不同
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();

            if (currProfit < newProfit){
                curr = m;
            }
        }
        return curr;
    }
}
