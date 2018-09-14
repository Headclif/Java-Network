package com.headclif.darkchat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private static final int PORT = 8189;
    private static ServerSocket serverSocket;
    private static Map<Socket, ClientObserver> clients = new HashMap<>();


    public static void main(String[] args) {
        run();
        observe();
        stop();
    }

    private static void run() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server running...");
        } catch (IOException e) {
            System.out.print("Server running exception: " + e);
        }
    }

    private static void observe() {

        while(true) {
            try {
                Socket socket = serverSocket.accept();
                ClientObserver client = new ClientObserver(socket);
                client.start();
                clients.put(socket, client);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ClientObserver getObserver(Socket socket) {
        return clients.get(socket);
    }

    public static void invalidate(Socket socket) {
        clients.remove(socket);
    }
}
