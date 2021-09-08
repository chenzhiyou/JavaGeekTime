package code020.supermarket;

public class MerchandiseMockThis {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe(MerchandiseMockThis This){
        System.out.println("商品的名字叫做"+ This.name+ "。id是" + This.id +".商品的单价是" + This.soldPrice
                + ".销售一个的毛利润是" + (This.soldPrice- This.purchasePrice));
    }

    public double calculateProfit(){
        double profit = soldPrice -purchasePrice;
        return profit;
    }

    public void  duplicateName(int count){

    }

    public int getCount(MerchandiseMockThis This){
        return This.count;
    }

    public void addCount(MerchandiseMockThis This, int count){
        This.count += count;
    }

    public boolean hasEnoughCountFor(MerchandiseMockThis This, int count){
        return This.count >= count;
    }

    public void makeEnoughFor(MerchandiseMockThis This, int count){
        boolean hasEnough = This.hasEnoughCountFor(This, count);
        if (!hasEnough){
            int toBeAdd = count - This.count;
            This.addCount(This, toBeAdd);
        }
    }
}
