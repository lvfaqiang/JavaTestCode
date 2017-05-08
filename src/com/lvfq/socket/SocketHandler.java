package com.lvfq.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 * SocketHandler
 *
 * @author lvfq
 * @date 2017/5/7 上午11:46
 * @mainFunction :
 */
public class SocketHandler implements Runnable {

    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            // 5，读取Client 端 写入过来的数据。
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String body = null;
            while (true) {
                // 读取客户端传递过来的数据。
                body = reader.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("Server : " + body);
                // 向客户端发送消息内容。
                writer.println("服务端向客户端返回的数据。。");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            socket = null;
        }
    }
}
