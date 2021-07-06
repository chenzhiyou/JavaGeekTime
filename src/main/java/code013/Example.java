package code013;

public class Example {
    public static void main(String[] args) {
        int a = 10;
        int b = 99;
        int c = 99;

        if (a ==b & b==c){
            System.out.println("a, b, c等大，大小为"+a );
        }else {
            if(a >b){
                if (a >c){
                    System.out.println( "a 是最大的值"+ a);
                }else {
                    if (a == c){
                        System.out.println("a和c都是最大的" + c);
                    }else {
                        System.out.println("c是最大的值" + c);
                    }
                }
            }else {
                if(b >c){
                    if (a==b){
                        System.out.println("a和b等大"+ b);
                    }else {
                        System.out.println("b最大，为" +b);
                    }
                }else {
                    if(c == b){
                        System.out.println("b和c等大，为"+ c);
                    }else {
                        System.out.println("c最大，为" +c);
                    }
                }
            }
        }
    }
}
