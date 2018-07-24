package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
                if (dataInputStream.available() > 0) {
                    //read and handled
                }
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
}
