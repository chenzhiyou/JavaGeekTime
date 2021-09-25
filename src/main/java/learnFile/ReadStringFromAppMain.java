package learnFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadStringFromAppMain {
    private static final String SOURCE_FILE_NAME = "测试文件.txt";

    public static void main(String[] args) {
        File sourceFile = new File("."+ File.separator +SOURCE_FILE_NAME);

        Scanner in = new Scanner(System.in);
        classicWay(sourceFile);
        coolerWay(sourceFile);


    }

    private static void classicWay(File sourceFile){
        System.out.println("---------经典的处理方法------------");
        try (FileInputStream fis = new FileInputStream(sourceFile);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr);
        ){
            String line = null;
            while ((line =reader.readLine()) !=null){
                System.out.println(line.trim().toUpperCase());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void  coolerWay(File sourceFile){
        System.out.println("---------666的处理方法------------");
        try (FileInputStream fis = new FileInputStream(sourceFile);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr);
        ){
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
