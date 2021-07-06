package code018;

import java.util.Scanner;

public class ReadStringAddIntFromConsole {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请问你的名字是？");

        String str = in.nextLine();

        System.out.println(str + "您好.");

        System.out.println("请问你几岁了？");

        int age = in.nextInt();

        System.out.println("好的，"+str +age + "岁了");
    }
}
