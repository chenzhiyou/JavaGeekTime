package code020.supermarket;

public class LittleSupperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2[] merchandises;
    public int[] merchandiseSold;

    // 初始化超市
    public void init(String superMarketName, String address, int parkingCount,
                     int merchandiseCount, int count){
        this.superMarketName = superMarketName;
        this.address = address;
        this.parkingCount = parkingCount;

        merchandises = new MerchandiseV2[merchandiseCount];
        for (int i=0; i <merchandises.length; i++){
            // 创建并给商品的属性赋值
            MerchandiseV2 m = new MerchandiseV2();
            m.count = count;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * m.purchasePrice;
            merchandises[i] = m;
        }
        merchandiseSold = new  int[merchandises.length];
    }
    //简单的访问成员变量
    public String getSuperMarketName(){
        return superMarketName;
    }

    // 返回值类型可以是类名，这时候实际返回的值就是这个类的引用
    public MerchandiseV2 getBiggerstProfitMerchandise(){
        MerchandiseV2 curr = null;
        for (int i = 0; i<merchandises.length; i++){
            MerchandiseV2 m = merchandises[i];
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
