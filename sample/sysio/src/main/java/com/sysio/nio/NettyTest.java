package com.sysio.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2020年09月20日 17:18
 */
public class NettyTest {

    public static void main(String[] args) throws IOException {
        //ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(8, 20);

    }

    @Test
    public void loopGroup() throws IOException {
        NioEventLoopGroup selector = new NioEventLoopGroup(3);
        selector.execute(()->{
            try {
                while (true) {
                    System.out.println("hello netty client1");
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        selector.execute(()->{
            try {
                while (true) {
                    System.out.println("hello netty client2");
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.in.read();
    }

    @Test
    public void client() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        NioSocketChannel socket = new NioSocketChannel();
        group.register(socket);// epoll_ctl
        // 异步
        ChannelFuture connect = socket.connect(new InetSocketAddress("127.0.0.1", 9090));
        ChannelFuture sync = connect.sync();
        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        socket.writeAndFlush(buf);

        sync.channel().closeFuture().sync();
        System.out.println("-------");
    }
}
