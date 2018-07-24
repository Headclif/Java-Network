package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLoader {
    private static ServerSocket server;
    private static int PORT = Configuration.PORT;

    public static void main(String[] args) {
        start();
        handle();
        stop();
    }

    private static void start() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle() {
        while (true) {
            try {
                Socket client = server.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(Configuration.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void stop() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
