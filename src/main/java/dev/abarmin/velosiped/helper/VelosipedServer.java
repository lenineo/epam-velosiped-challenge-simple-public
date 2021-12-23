package dev.abarmin.velosiped.helper;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import dev.abarmin.velosiped.task1.SumHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class VelosipedServer {
    public static HttpServer createVelosipedServer(int port, String endpoint, HttpHandler handler){
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            httpServer.createContext(endpoint, handler);
            httpServer.setExecutor(null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpServer;
    }
}
