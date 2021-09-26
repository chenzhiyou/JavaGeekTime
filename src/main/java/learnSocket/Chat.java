package learnSocket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static learnSocket.SimpleServer.BYE;
import static learnSocket.SimpleServer.SERVER_CHARSET;

public class Chat {
    private String from;
    private String greeting;
    private Socket socket;

    public Chat(String from, String greeting, Socket socket) {
        this.from = from;
        this.greeting = greeting;
        this.socket = socket;
    }

    public void chatting(){
        Scanner in = new Scanner(System.in);
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), SERVER_CHARSET));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), SERVER_CHARSET));
                ){
            System.out.println("Socket连接成功！简历输入输出");
            if (greeting !=null){
                pw.println("您好" + from + "." + greeting);
            }
            while (true){
                String line = br.readLine();
                if (line.trim().equalsIgnoreCase(BYE)){
                    System.out.println("对方要求断开连接");
                    pw.println(BYE);
                    pw.flush();
                    break;
                }else {
                    System.out.println("来自\"" + from + "\"的消息:" + line);
                    line = in.nextLine();
                    pw.println(line);
                    pw.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
