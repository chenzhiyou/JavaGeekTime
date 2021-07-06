package code012;

public class Print26Chars {
    public static void main(String[] args) {
        char ch = 'a';
        int num = ch;
        for(int i =0; i<26; i++){
            System.out.println(num + "\t" + ((char)(num++)));
        }
    }
}
