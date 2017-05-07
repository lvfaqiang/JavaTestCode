package com.lvfq.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 *
 * @author lvfq
 * @date 2017/5/7 上午11:45
 * @mainFunction :
 */
public class Server {

    public static final int PORT = 8765;  // 端口号。

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务端启动，等待连接。。");

            Socket socket = serverSocket.accept();  // 等待建立连接。
            // 连接成功之后，进入真正的处理响应程序。
            new Thread(new SocketHandler(socket)).start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
