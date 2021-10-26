package chatroom.common;

import java.nio.charset.Charset;
import java.util.Objects;

import static chatroom.common.Constants.MESSAGE_SEP;
import static chatroom.common.Constants.MESSSAGE_BREAK;

public class ChatMessage {

    private String from;
    private String to;
    private String message;

    public ChatMessage(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message.trim();
    }

    private ChatMessage(){

    }

    public ChatMessage(String adminName, String from) {
    }

    public static ChatMessage buildFrom(String message){
        ChatMessage ret = new ChatMessage();
        int fromEnd = message.indexOf(MESSAGE_SEP);
        ret.from = message.substring(0, fromEnd);
        int toEnd = message.indexOf(MESSAGE_SEP, fromEnd+1);
        ret.to = message.substring(fromEnd+1, toEnd);
        ret.message = message.substring(toEnd+1).trim();
        return ret;
    }

    public String toMessageString(){
        StringBuilder ret = new StringBuilder();
        ret.append(from).append(MESSAGE_SEP).append(to).append(MESSAGE_SEP).append(message).append(MESSSAGE_BREAK);
        return ret.toString();
    }

    public static void main(String[] args) {
        ChatMessage chatMessage = new ChatMessage("testfrom", "testto","只是一条消息");
        String strMessage = chatMessage.toMessageString().trim();
        System.out.println(strMessage);
        ChatMessage parsed = buildFrom(strMessage);
        System.out.println(parsed.equals(chatMessage));
    }

    public boolean equals(Object o){
        if (this==o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that =(ChatMessage) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(message, that.message);
    }

    public int hashCode(){
        return Objects.hash(from, to, message);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

