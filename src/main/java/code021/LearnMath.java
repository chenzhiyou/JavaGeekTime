package code021;

import java.util.Random;

public class LearnMath {
    public double abc;

    public static void main(String[] args) {
        // 我们调用的都是Math里的静态方法，math的构造函数就是private的，意味着不能创建Math类的实例
        System.out.println(Math.random());
        // 原来归根结底，Math的random是用的Random类来实现的，在Java.util包里
        Random random = new Random();
        for (int i = 0; i <100; i++){
            // nextInt的返回值竟然有正数有负数
            System.out.println(random.nextInt());
        }

        System.out.println(Math.abs(-9));
        System.out.println(Math.round(-9.5));
        System.out.println(Math.round(-9.8));
        System.out.println(Math.round(9.5));
        System.out.println(Math.round(9.8));
    }
}
