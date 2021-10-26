package chatroom.common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public interface Constants {
    int SERVER_PORT = 45678;

    Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    char MESSAGE_SEP = Character.UNASSIGNED;
    String SPACE_STRING = "";
    String MESSAGE_SEP_STR = String.valueOf(Character.UNASSIGNED);

    String ADMIN_NAME="admin";
    String USER_NAME_PASS = "UserNamePass";
    String COMMAND_INTRODUCTION = "欢迎来到聊天室，你可以使用@admin list查看所有在线用户";
    String CHAT_WITH_START ="@";
    String NO_NAME = "anonymous";
    String SERVER_COMMAND_LOGOOF="logoff";
    String SERVER_COMMAND_LIST ="list";
    String BYE = "bye";
    String MESSSAGE_BREAK ="\n";
}
