package supermark.interfaces;

public interface SuperMarket {
    // 获取商品接口
    Merchandise[] getAllMerchandise();
    // 随机根据品类选择商品
    Merchandise[] getRandomMerchandiseOfCategory(Category category);

    // 计算价钱
    void addEarnedMoney(double earnedMoney);

    //打印一天的收益
    void dailyReport();
}
