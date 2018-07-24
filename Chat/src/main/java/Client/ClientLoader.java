package Client;

import Server.Configuration;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientLoader {
    private static Socket socket;

    public static void main(String[] args) {
        connect();
        handle();
        disconnect();
    }

    private static void connect() {
        try {
            socket = new Socket("localhost", 6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle() {
        while (true) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
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

    private static void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
