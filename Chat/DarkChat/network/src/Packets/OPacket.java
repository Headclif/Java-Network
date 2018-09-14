package Packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class OPacket {

    private Socket client;

    public Socket getSocket() {
        return client;
    }

    public void setSocket(Socket socket) {
        this.client = socket;
    }

    public abstract short getId();
    public abstract void write(DataOutputStream dos) throws IOException;
    public abstract void read(DataInputStream dis) throws IOException;
    public abstract void handle();
}
