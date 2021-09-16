package code020.supermarket;

import java.util.Date;

public class GamePointCard extends MerchandiseV2 implements ExpireDateMerchandise, VirtualMerchandise{

    private Date produceDate;
    private Date expirationDate;

    public GamePointCard(String name, String id, int count, double soldPrice,
                         double purchasePrice,Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean notExpireInDays(int days) {
        return daysBeforeExpire() > days;
    }

    private long daysBeforeExpire() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0){
            return -1;
        }

        return left/(24*3600*1000);

    }

    @Override
    public Date getProducedDate() {
        return null;
    }

    @Override
    public Date getExpireDate() {
        return null;
    }

    @Override
    public double leftDatePercentage() {
        return 1.0* daysBeforeExpire()/(daysBeforeExpire() + daysAfterProduce());
    }

    private long daysAfterProduce() {
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0){
            return -1;
        }

        return left/(24*3600*1000);
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return soldPrice;
    }
}
