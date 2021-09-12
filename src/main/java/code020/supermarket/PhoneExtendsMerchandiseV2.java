package code020.supermarket;

public class PhoneExtendsMerchandiseV2 extends MerchandiseV2{

    private double screesSize;
    private double cpuHZ;
    private int mermoryG;
    private int storageG;
    private String brand;
    private String os;

    private static int MAX_BUY_ONE_ORDER = 1;

    public PhoneExtendsMerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice,
                                     double screesSize, double cpuHZ, int mermoryG, int storageG,String brand,
                                     String os){
        this.screesSize = screesSize;
        this.cpuHZ = cpuHZ;
        this.mermoryG = mermoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;

    }

    /**
     *
     * @param countToBuy
     * @return
     * 通过使用和父类方法签名一样，而且返回值也必须一样的方法，可以让子类覆盖（override）掉父类的方法
     * 也就是说，子类并不是只能把父类的方法拿过来，而且可以通过覆盖来替换其中不适合子类的方法
     * 题外话：属性是联动的，可能是有特殊意义的
     * 所以直接给属性赋值是危险的，因为没有办法检查新的值是否有意义，也没法对这个修改做联动的修改
     */
    public double buy(int countToBuy){
        if (countToBuy > MAX_BUY_ONE_ORDER){
            System.out.println("购买失败，手机一次最多只能买"+ MAX_BUY_ONE_ORDER + "个");
            return -2;
        }
        // 使用super可以调用父类的方法和属性（当然必须满足访问控制符的控制）
        return super.buy(countToBuy);
//        if (this.count < countToBuy){
//            System.out.println("购买失败，库存不够");
//            return -1;
//        }
//        this.count -= countToBuy;
//        double cost = countToBuy*soldPrice;g
//        System.out.println("购买成功，花费"+cost);
//        return cost;
    }
    public void describe(){
        System.out.println("此手机商品信息如下:");
        super.describe();
        System.out.println("手机厂商为"+brand);
    }
}
