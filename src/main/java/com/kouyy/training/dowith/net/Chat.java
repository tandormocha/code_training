package com.kouyy.training.dowith.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static com.kouyy.training.dowith.net.SimpleServer.BYE;
import static com.kouyy.training.dowith.net.SimpleServer.SERVER_CHARSET;

/**
 * @author kouyouyang
 * @date 2020-03-29 17:40
 */
public class Chat {
    public String from;
    public String greetings;
    public Socket socket;

    public Chat(String from, String greetings, Socket s) {
        this.from = from;
        this.greetings = greetings;
        this.socket = s;
    }

    public void chatting() {
        Scanner in = new Scanner(System.in);
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), SERVER_CHARSET));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), SERVER_CHARSET));
        ) {
            System.out.println("socket连接已经成功，建立输入输出");
            if (greetings != null) {
                pw.println("你好" + from + "-" + greetings);
                pw.flush();
            }
            while (true) {
                String line = br.readLine();
                if (line.trim().equalsIgnoreCase(BYE)) {
                    System.out.println("对方要求断开连接");
                    pw.println(BYE);
                    pw.flush();
                    break;
                } else {
                    System.out.println("来自" + from + "的消息：" + line);
                }
                line = in.nextLine();
                pw.println(line);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("聊天结束");


    }
}
