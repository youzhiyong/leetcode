package com.yzy.io.sever;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 需要引入netty的JAR包
 <dependency>
 <groupId>io.netty</groupId>
 <artifactId>netty-all</artifactId>
 <version>4.1.34.Final</version>
 </dependency>


 * Description: NIO编程中服务端
 * Date: 2019-03-22
 *
 * @author youzhiyong
 */
public class NettyServer {

    public static void main(String[] args) {
        System.out.println("NettyServer start");
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup main = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(main, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) {
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) {
                                System.out.println(s);
                            }
                        });
                    }
                })
                .bind(8080);
    }

}
