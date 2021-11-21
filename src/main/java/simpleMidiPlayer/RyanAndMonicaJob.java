package simpleMidiPlayer;

import simpleDotGame.B;

public class RyanAndMonicaJob implements Runnable{
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            makwWithdrawal(10);
            if (account.getBalance() < 0){
                System.out.println("OverDrawn");
            }
        }
    }

    private synchronized void makwWithdrawal(int amount){
        if (account.getBalance() > amount){
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName()+ " is going to sleep");
                Thread.sleep(500);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw");
        }else {
            System.out.println("sorry , not enough for " + Thread.currentThread().getName());
        }
    }
}
