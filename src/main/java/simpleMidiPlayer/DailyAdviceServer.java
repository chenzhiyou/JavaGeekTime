package simpleMidiPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = {
            "Take smaller bites",
            "Go for the tight jeans. No they do not make you look fat",
            "One word:inappropriate",
            "just for today, be honest.tell your boss with you *really* think",
            "You might want to rethink that haircut"
    };

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    public void go(){
        try {
            // serverSocket会监听客户端对这台机器在4242端口上的要求
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true){
                // 这个方法会停下来等待要求到达之后才会继续
                Socket socket = serverSocket.accept();
                PrintWriter writer =new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);

            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int)(Math.random()*adviceList.length);
        return adviceList[random];
    }
}
