package simpleDotGame;

public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfguesses =0;
        GameHelper helper = new GameHelper();

        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int)(Math.random() *5);

        int[] locations = {randomNum, randomNum+1, randomNum+2};
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive){
            String guess = helper.getUserInput("enter a number");
            String result = theDotCom.checkYourself(guess);
            numOfguesses ++;
            if (result.equals("kill")){
                isAlive = false;
                System.out.println("You took " +numOfguesses +" guesses");
            }
        }
    }
}
