package dev.abarmin.velosiped.task1;

import com.sun.net.httpserver.HttpServer;
import dev.abarmin.velosiped.helper.VelosipedServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class VelosipedTask1Impl implements VelosipedTask1{

    private HttpServer httpServer;

    @Override
    public void startServer(int port) {
        httpServer = VelosipedServer.createVelosipedServer(port, "/sum", new SumHandler());
        httpServer.start();
    }

    @Override
    public void stopServer() {
        httpServer.stop(10);
    }
}
