package com.yzy.io.sever;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Description: NIO编程中服务端 当有N个请求时，线程数为1 + 1 个，即一个监听连接的线程和一个处理所有连接的线程
 * Date: 2019-03-22
 *
 * @author youzhiyong
 */
public class NIOServer {

    public static void main(String[] args) throws Exception {
        System.out.println("NIOServer start");
        Selector mainSelector = Selector.open(); //用于监听连接
        Selector workerSelector = Selector.open();  //用于处理每个连接

        new Thread(() -> {
            try {
                // 对应IO编程中服务端启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8080));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(mainSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    // 监测是否有新的连接，这里的1指的是阻塞的时间为1ms
                    if (mainSelector.select(1) > 0) {
                        System.out.println("New Connection come in ");
                        Set<SelectionKey> set = mainSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();

                            if (key.isAcceptable()) {
                                try {
                                    // (1) 每来一个新连接，不需要创建一个线程，而是直接注册到workerSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(workerSelector, SelectionKey.OP_READ);
                                } finally {
                                    iterator.remove();
                                }
                            }
                        }
                    }

                }

            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    // (2) 批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为1ms
                    if (workerSelector.select(1) > 0) {
                        Set<SelectionKey> set = workerSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = set.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            if (key.isReadable()) {
                                try {
                                    SocketChannel channel = (SocketChannel)key.channel();
                                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                                    // (3) 读取数据以块为单位批量读取
                                    channel.read(buffer);
                                    buffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(buffer).toString());
                                } finally {
                                    iterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {

            }
        }).start();


    }
}
