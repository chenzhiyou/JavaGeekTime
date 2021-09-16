package code020.supermarket;

import java.util.Date;

public interface ExpireDateMerchandise {

    boolean notExpireInDays(int days);

    Date getProducedDate();

    public abstract Date getExpireDate();

    double leftDatePercentage();

    double actualValueNow(double leftDatePercentage);
}
