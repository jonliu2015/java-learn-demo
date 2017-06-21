package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by Liu.Zheng on 2017/4/25.
 */
public class BioServer {
    public void server(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            while (true) {
                final Socket socket = serverSocket.accept();
                System.out.println("bio server at: http://localhost:" + port);
                new Thread(() -> {
                    OutputStream outputStream;
                    try {
                        outputStream = socket.getOutputStream();
                        outputStream.write("hello world!".getBytes(Charset.forName("utf-8")));
                        outputStream.flush();
                        System.out.println("success");
                    } catch (IOException e) {
                        System.err.println(e.toString());
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            System.err.println(e.toString());
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }
}
