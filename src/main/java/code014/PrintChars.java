package code014;

public class PrintChars {
    public static void main(String[] args) {
        char ch = 'A';
        int starNum = ch;
        for (int i = 0; i <26; i++){
            int newNum = starNum + i;
            System.out.println(newNum + "\t" +((char) newNum));
        }
    }
}
