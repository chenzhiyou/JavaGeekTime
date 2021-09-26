package learnSocket;

import java.io.IOException;
import java.net.Socket;

import static learnSocket.SimpleServer.SERVER_PORT;

public class SimpleClient {
    public static void main(String[] args) {
        commWithServer();
    }
    private static void commWithServer(){
        try (
                Socket socket = new Socket("localhost", SERVER_PORT);
        ){
                Chat chat = new Chat("服务器端", null, socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("程序退出!");
    }
}
