package code018;

public class RandomNumber {
    public static void main(String[] args) {
        double  randNum = 0;

        while (randNum <0.5){
            randNum = Math.random();
            System.out.println(randNum);
        }

        System.out.println("生成的大于0.5的随机数是"+ randNum);

        int rangeStart = 30;
        int rangeEnd = 90;
        if (rangeStart<0 || rangeEnd<0){
            System.out.println("开始和结束必须是正整数或者0");
        }

        int mod = rangeEnd - rangeStart;

        if (mod <=1){
            System.out.println("非法的数字范围：" + rangeStart +"," +rangeEnd);
        }
        for (int i =0; i <50; i++){
            int bigRandom =(int) (Math.random()* (rangeEnd*100));

            int numberToGuess = (bigRandom % mod) +rangeStart;

            if (numberToGuess <= rangeStart){
                numberToGuess = rangeStart+1;
            }else if (numberToGuess > rangeEnd){
                numberToGuess = rangeEnd-1;
            }
            System.out.println("mod="+ mod +"，bigRandom=" + bigRandom);
            System.out.println("numberToGuess=" +numberToGuess);
        }

    }
}
