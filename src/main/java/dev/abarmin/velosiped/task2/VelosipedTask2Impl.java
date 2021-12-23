package dev.abarmin.velosiped.task2;

import com.sun.net.httpserver.HttpServer;
import dev.abarmin.velosiped.helper.VelosipedServer;
import dev.abarmin.velosiped.task2.SumHandler;

public class VelosipedTask2Impl implements VelosipedTask2{

    private HttpServer httpServer;
    @Override
    public void startServer(int port) {
        httpServer = VelosipedServer.createVelosipedServer(port, "/sum", new SumHandler());
        httpServer.start();
    }

    @Override
    public void stopServer() {
        httpServer.stop(1);
    }
}
