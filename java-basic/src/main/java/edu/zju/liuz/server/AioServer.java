package server;

import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * Created by Liu.Zheng on 2017/6/21.
 */
public class AioServer {
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;
    AioServer(int port) {
        asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
    }
}
