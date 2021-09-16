package code020.supermarket;

import java.util.Date;

public class TestInterface implements ExpireDateMerchandise{

    @Override
    public boolean notExpireInDays(int days) {
        return false;
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
        return 0;
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return 0;
    }
}
