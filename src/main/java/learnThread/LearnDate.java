package learnThread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LearnDate {
    public static void main(String[] args) {
        opearateTime();
        initCalendar();
        setTimeManually();
    }

    public static void setTimeManually(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.NOVEMBER, 20,21, 36,55);
        Date date = calendar.getTime();
        System.out.println(date);

        /***
         * SimpleDateFormat不是线程安全的，对线程共用一个instance会有问题
         * 可以考虑用ThreadLocal给每个工作线程分配一个，也可以每次用到的时候创建实例
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH ");
        System.out.println(sdf.format(date));
    }

    private static void initCalendar(){
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(System.currentTimeMillis()- TimeUnit.DAYS.toMillis(10));
        c2.setTime(new Date());
    }

    private static void opearateTime(){
        // 默认当前时间
        Calendar calendar = Calendar.getInstance();
        //使用Calendar 可以对时间进行加减
        calendar.add(Calendar.DAY_OF_YEAR, 100);
        calendar.add(Calendar.MINUTE, 100);
        //可以方便的得到data对象
        Date date = calendar.getTime();
    }
}
