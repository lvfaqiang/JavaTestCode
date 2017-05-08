package com.lvfq.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

import static com.lvfq.socket.Server.PORT;

/**
 * Client
 *
 * @author lvfq
 * @date 2017/5/7 上午11:45
 * @mainFunction :
 */
public class Client {

    private static String host = "127.0.0.1";

    public static void main(String[] args) {
        BufferedReader reader = null;
        Socket socket = null;
        PrintWriter writer = null;
        try {
            // 3, 初始化 Client 端 Socket ,同时也是与对应 IP,以及相同端口号的服务端的 ServerSocket 建立连接。
            socket = new Socket(host, PORT);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 向 服务端发送消息
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("客户端接收到请求数据。。。。");

            // reader.readLine() 读取服务端返回的数据，
            System.out.println("Client : " + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (writer != null) {
                    writer.close();
                }

                if (reader != null) {
                    reader.close();
                }

                if (socket != null) {
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
