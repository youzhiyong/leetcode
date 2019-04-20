package com.yzy.io.sever;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: IO编程中服务端 当有N个请求时，线程数为N + 1 个
 * Date: 2019-03-22
 *
 * @author youzhiyong
 */
public class IOServer {

    public static void main(String[] args) throws Exception {
        System.out.println("IOServer start");
        ServerSocket serverSocket = new ServerSocket(8080);

        new Thread(() -> {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Connected with socket: " + socket);
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Socket disconnected");
                        }
                    }).start();
                }
            } catch (Exception e) {
                System.out.println("Server Shutdown");
            }

        }).start();

    }
}
