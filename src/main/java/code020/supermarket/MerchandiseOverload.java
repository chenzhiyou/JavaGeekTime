package code020.supermarket;

public class MerchandiseOverload {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public  double purchasePrice;

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

    // buy方法的重载
    public double buy(){
        return buy(1);
    }

    public double buy(int count){
        return buy(count, false);
    }

    public double buy(int count, boolean isVIP){
        if (this.count < count){
            return -1;
        }
        this.count -= count;
        double totalCost = count *soldPrice;
        if (isVIP){
            return totalCost * 0.95;
        }else {
            return totalCost;
        }
    }

}
