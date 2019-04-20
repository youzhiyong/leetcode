package com.yzy.io.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 * Date: 2019-03-23
 *
 * @author youzhiyong
 */
public class IOClient {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                while (true) {
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write((new Date() + "youzhiyong").getBytes());
                    outputStream.flush();
                    Thread.sleep(200);
                }
            } catch (Exception e) {
                System.out.println("Connected Error");
            }

        }).start();
    }

}
