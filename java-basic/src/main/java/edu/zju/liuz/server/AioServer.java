package edu.zju.liuz.server;

import java.io.IOException;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * Created by Liu.Zheng on 2017/6/21.
 */
public class AioServer {
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    AioServer(int port) {
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
