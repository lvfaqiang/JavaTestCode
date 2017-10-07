package com.lvfq.netty;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * HelloClientHandler
 *
 * @author lvfq
 * @date 2017/9/28 上午9:45
 * @mainFunction :
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<byte[]> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx
            , byte[] msg) throws Exception {
        for (byte b : msg) {
            System.out.print(b + " ");
        }
        System.out.println("server say : " + byte2hex(msg));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client active ");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client close ");
        super.channelInactive(ctx);
    }


    public static final String byte2hex(byte b[]) {
        if (b == null) {
            throw new IllegalArgumentException(
                    "Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        String[] strings = new String[b.length];
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
                strings[n] = "0" + stmp;
            } else {
                hs = hs + stmp;
                strings[n] = stmp;
            }
        }
        for (String s : strings) {
            System.out.print(s + " ");
        }
        return hs.toUpperCase();
    }
}