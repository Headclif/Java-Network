package Packets;

import com.headclif.darkchat.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class IdentificatePacket extends OPacket {

    private String nickname;

    IdentificatePacket() {

    }

    IdentificatePacket(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public short getId() {
        return 1;
    }

    //for client
    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(nickname);
    }

    //for server
    @Override
    public void read(DataInputStream dis) throws IOException {
        nickname = dis.readUTF();
    }

    @Override
    public void handle() {
        Server.getObserver(getSocket()).setNickname(nickname);
    }
}
