package com.kouyy.training.dowith.net;


import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author kouyouyang
 * @date 2020-03-29 17:40
 */
public class SimpleServer {
    public static final int SERVER_PORT = 4562;
    public static final Charset SERVER_CHARSET = StandardCharsets.UTF_8;
    public static final String BYE = "bye";

    public static void main(String... args) {
        commWithClient();
    }

    public static void commWithClient() {
        System.out.println("服务端已经启动，在端口" + SERVER_PORT + "监听");
        try {
            ServerSocket ss = new ServerSocket(SERVER_PORT);
            Socket s = ss.accept();
            Chat chat = new Chat("客户端", "你已经成功连接到我，我们开始对话了", s);
            chat.chatting();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序退出");

    }


}
