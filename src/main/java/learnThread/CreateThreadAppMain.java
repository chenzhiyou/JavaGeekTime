package learnThread;

public class CreateThreadAppMain {
    public static String TEXT = "我独自走在郊外的小路上";
    public static void main(String[] args) {
        System.out.println("程序开始，执行的线程名字叫做"+ Thread.currentThread().getName());

        for (int i=1; i <=1; i++){
            Thread thread = new Thread(new  PrintStoryRunnable(TEXT, 200*i), "我的线程-" +i);
            thread.start();
        }
    }

    static class PrintStoryRunnable implements Runnable{

        private String text;
        private long interval;

        public PrintStoryRunnable(String text, long interval){
            this.text = text;
            this.interval = interval;
        }

        @Override
        public void run() {

        }
    }
}
