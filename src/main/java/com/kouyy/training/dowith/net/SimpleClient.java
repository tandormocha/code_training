package com.kouyy.training.dowith.net;

import java.net.Socket;

import static com.kouyy.training.dowith.net.SimpleServer.SERVER_PORT;

/**
 * @author kouyouyang
 * @date 2020-03-29 17:40
 */
public class SimpleClient {

    public static void main(String... args) {
        commWithClient();
    }

    public static void commWithClient() {
        System.out.println("客户端已经在端口" + SERVER_PORT + "启动");
        try{
            Socket ss=new Socket("localhost",SERVER_PORT);
            Chat chat=new Chat("服务器端",null,ss);
            chat.chatting();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序退出");

    }
}
