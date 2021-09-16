package code020.supermarket;

import java.util.Date;

public abstract class AbstractExpireDateMerchandise extends MerchandiseV2 implements ExpireDateMerchandise{

    private Date produceDate;
    private Date expirationDate;

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice,
                                         Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;

    }

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice,
                                         Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;

    }

    public  AbstractExpireDateMerchandise(Date produceDate, Date expirationDate){
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
    }

    public AbstractExpireDateMerchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        super(name, id, count, soldPrice, purchasePrice);
    }

    public boolean notExpireInDays(int days){
        return daysBeforeExpire() > days;
    }

    protected  double daysBeforeExpire(){
        long expireMS = expirationDate.getTime();
        long left = expireMS - System.currentTimeMillis();
        if (left < 0){
            return -1;
        }

        return 1.0*left/(24*3600*1000);

    };
}
