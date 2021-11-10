package simpleDotGame;

public class TestBox {
    Integer i;
    int j;

    public void go(){
        System.out.println(j);
        System.out.println(i);
        j=i;
        System.out.println(j);
        System.out.println(i);
    }

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }
}
