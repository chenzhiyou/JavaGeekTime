package code020;

import code020.supermarket.LittleSupperMarket;
import code020.supermarket.MerchandiseV2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAppMain {
    public static void main(String... args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LittleSupperMarket supperMarket = new LittleSupperMarket();
        supperMarket.init("大卖场", "世纪大道1号",500, 600, 100);

        MerchandiseV2 m100 = new MerchandiseV2();
        Class clazz = MerchandiseV2.class;
        Field countField = clazz.getField("count");
        System.out.println("通过反射获取count值："+ countField);

        Method buyMethod = clazz.getMethod("buy", int.class);
        System.out.println(buyMethod.invoke(m100, 10));

        Method descMethod = clazz.getMethod("describe");
        descMethod.invoke(m100);


    }
}
