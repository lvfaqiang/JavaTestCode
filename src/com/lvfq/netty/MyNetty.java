package com.lvfq.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MyNetty
 *
 * @author lvfq
 * @date 2017/9/28 上午9:20
 * @mainFunction :
 */
public class MyNetty {

    //    public static String host = "101.132.99.221";
    public static String host = "192.168.30.61";
    public static int port = 8888;

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new HelloClientInitializer());

            ChannelFuture c = b.connect(host, port).sync();
            if (c.isSuccess()) {

            }
            // 连接服务端
            Channel ch = c.channel();

            // 控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                byte[] line = in.readLine().getBytes();
                if (line == null || line.length <= 0) {
                    continue;
                }
                    /*
          * 向服务端发送在控制台输入的文本 并用"\r\n"结尾
          * 之所以用\r\n结尾 是因为我们在handler中添加了 DelimiterBasedFrameDecoder 帧解码。
                * 这个解码器是一个根据\n符号位分隔符的解码器。所以每条消息的最后必须加上\n否则无法识别和解码
                * */
                ch.writeAndFlush(line);
            }
        } finally {
            // The connection is closed automatically on shutdown.
            group.shutdownGracefully();
        }
    }
}

