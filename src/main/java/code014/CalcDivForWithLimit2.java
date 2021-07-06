package code014;

public class CalcDivForWithLimit2 {
    public static void main(String[] args) {
        int divided =5;
        int divisor = 30;

        int found =0;
        int toBeFound =10;
        for (int i =0; i<100 && found <10; i++){
            if(divided <divisor){
                divided ++;
                System.out.println(divided +"小于"+ divisor+",当前循环跳出");
                continue;
            }
            if (divided % divisor ==0){
                System.out.println(divided + "可以整除" + divisor + ",商为"+ (divided/divisor));
                found ++;
            }
            if (found >= toBeFound){
                System.out.println("已经找到"+ toBeFound+"个数，循环退出");
            }
            divided ++;
        }
    }
}
