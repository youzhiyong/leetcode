package com.yzy.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从channel读写数据到buffer
 * author:youzhiyong
 * date:2019-04-21
 */
public class TestBuffer {

    public static void main(String[] args) throws Exception {
        String path = TestBuffer.class.getResource("").getPath();
         // "D:\\Project\\java_project\\leetcode\\src\\com\\yzy\\nio";
        RandomAccessFile file = new RandomAccessFile(path + "/nio-data.txt", "rw");
        FileChannel channel = file.getChannel();

        readFromChannel(channel);

        writeToChannel(channel, "youzhiyong");

        file.close();

    }

    private static void readFromChannel(FileChannel channel) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        int n = channel.read(buffer);

        while (n != -1) {

            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            n = channel.read(buffer);
        }
    }

    private static void writeToChannel(FileChannel channel, String msg) throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

        channel.write(buffer);
    }

}
