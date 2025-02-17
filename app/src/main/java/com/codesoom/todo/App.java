package com.codesoom.todo;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
            HttpServer httpServer = HttpServer.create(inetSocketAddress, 0);
            HttpHandler handler = new ToDoHandlerMapping();
            httpServer.createContext("/", handler);
            httpServer.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
