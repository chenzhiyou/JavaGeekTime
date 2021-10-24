package learnThread;

import java.util.TimerTask;

// 必须继承TimerTask 才能被timer schedule
public class FindABCTask extends TimerTask {

    @Override
    public void run() {
        try{
            String content = getWebContent();
            if (content.contains("ABC")){
                System.out.println("Find ABC in "+ content);
            }else {
                System.out.println("ABC not found");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static String getWebContent(){
        StringBuilder ret = new StringBuilder();
        for (int i =0; i<4096;i++){
            int rand = ((int)(Math.random()*1000))%26;
            char ch = (char)(rand+'A');
            ret.append(ch);
        }
        return ret.toString();
    }
}
