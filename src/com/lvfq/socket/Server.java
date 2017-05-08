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
    /**
     * 首先，创建 服务端，初始化 ServerSocket , 然后调用 accept 方法，等待客户端的连接， 这个时候，服务端是处于线程等待状态，
     * 然后，在 client 端，初始化 Socket ,参数配置为对应的服务端 IP地址，以及和服务端保持一致的端口号。
     * 当 Client端的 Socket 初始化成功之后，就标明以及连接成功。
     * 通过 PrintWirter 来进行发送消息到 ServerSocket , BufferedReader 来读取消息。
     */

    public static final int PORT = 8765;  // 端口号。

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 1，初始化服务端 ServerSocket ,
            serverSocket = new ServerSocket(PORT);
            System.out.println("服务端启动，等待连接。。");

            // 2，serverSocket.accept() 方法，等待客户端连接，处于线程阻塞状态。
            Socket socket = null;

            // 4， 连接成功之后，进入真正的处理响应程序。
            System.out.println("服务端已被连接。。。");
//            new Thread(new SocketHandler(socket)).start();

            HandlerExecutorsPool pool = new HandlerExecutorsPool(20, 1000);
            while (true) {
                // 这里用 while 循环的原因， 一个服务端，同时会有很多个 socket 进行连接，如果不循环的话，那么当有一个进行阻塞之后，后面的就不能再访问了。
                socket = serverSocket.accept();
                pool.execute(new SocketHandler(socket));
            }

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
