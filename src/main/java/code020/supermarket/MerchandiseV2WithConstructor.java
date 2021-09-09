package code020.supermarket;

public class MerchandiseV2WithConstructor {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public  double purchasePrice;

    public  MerchandiseV2WithConstructor(String name, String id,
                                         int count, double soldPrice,
                                         double purchasePrice){
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





}
