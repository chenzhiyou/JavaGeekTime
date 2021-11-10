package testSimpleDaotGame;

import simpleDotGame.SimpleDotCom;

public class SimpleDotComTestDriver {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();

        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        String userguess ="5";
        String result = dot.checkYourself(userguess);

        String testResult ="failed";
        if (result.equals("hit")){
            testResult ="passed";
        }
        System.out.println(testResult);
    }
}
