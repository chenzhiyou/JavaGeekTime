package code012;

public class FindDiv {
    public static void main(String[] args) {
        int div = 77;
        int divsor = 9;
        for(int i = 0; i <100; i++){
            if (div++ %divsor==0){
                System.out.println(div + "可以整除" + divsor );
            }
        }
    }
}
