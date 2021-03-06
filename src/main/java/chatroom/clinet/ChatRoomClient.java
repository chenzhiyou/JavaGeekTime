//package chatroom.clinet;
//
//import chatroom.common.ChatMessage;
//import chatroom.common.DataExchange;
//import chatroom.common.Utils;
//import com.sun.tools.javac.tree.JCTree;
//import learnSocket.Chat;
//
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Scanner;
//
//import static chatroom.common.Constants.*;
//
//public class ChatRoomClient {
//    private String server;
//    DataExchange exchange;
//    private String userName;
//    private String currentToName;
//    private Scanner input = new Scanner(System.in);
//
//    public ChatRoomClient(String server) throws IOException {
//        System.out.println("客户端连接中。。。。。");
//        this.server = server;
//        Socket socket = new Socket(server, SERVER_PORT);
//        System.out.println("客户端已链接到服务器" + socket.getRemoteSocketAddress());
//        exchange = new DataExchange(socket);
//        this.server = server;
//    }
//
//    public void start() throws IOException {
//        initName();
//
//        Thread readThread = new Thread(()->{
//                while (true){
//                    try {
//                        ChatMessage chatMessage = exchange.receive();
//                        if (chatMessage.getFrom().equalsIgnoreCase(ADMIN_NAME)
//                                &&chatMessage.getMessage().trim().equalsIgnoreCase(BYE)){
//                            exchange.close();
//                            System.out.println("已经离开聊天室，程序结束");
//                            System.out.println(0);
//                        }
//                        System.out.println("form\"" + chatMessage.getFrom()+ "\": " +chatMessage.getMessage());
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                        exchange.close();
//                        System.exit(-2);
//                    }
//                }
//        });
//        readThread.start();
//
//        Thread writeThread = new Thread(()->{
//            while (true){
//                try {
//                    exchange.send(createChatMessage());
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                    exchange.close();
//                    System.exit(-3);
//                }
//            }
//        });
//        writeThread.start();
//    }
//
//    private ChatMessage createChatMessage(){
//        while (true){
//            String line = input.nextLine().trim();
//            String to = null;
//            String message = null;
//            try {
//                if (line.startsWith(CHAT_WITH_START)){
//                    to = line.substring(1, line.indexOf(SPACE_STRING)).trim();
//                    String error = Utils.isValidToUserName(to);
//                    if (error == null){
//                        currentToName = to;
//                        message = line.substring(line.indexOf(SPACE_STRING)+1);
//                    }else{
//                        System.out.println("用户名\"" + to + "\"不合法" + error);
//                        continue;
//                    }
//                }else {
//                    if (currentToName == null){
//                        System.out.println("请使用@输入想和谁聊天，以后如果和同一个人聊天，就可以不用@啦");
//                        continue;
//                    }
//                    message = line;
//                }
//            } catch (Exception ex){
//                System.out.println("输入的消息不对" +line);
//                continue;
//            }
//            return new ChatMessage(userName, currentToName, message);
//        }
//    }
//
//    private void initName() throws IOException {
//        String typeName = null;
//        while (true){
//            ChatMessage chatMessage = exchange.receive();
//            String serverMessage = chatMessage.getMessage();
//            if (serverMessage.equalsIgnoreCase(USER_NAME_PASS)){
//                userName = typeName;
//                break;
//            }else {
//                System.out.println(serverMessage);
//                typeName = input.nextLine();
//                exchange.send(new ChatMessage(NO_NAME, ADMIN_NAME, typeName.trim()));
//            }
//        }
//    }
//}
