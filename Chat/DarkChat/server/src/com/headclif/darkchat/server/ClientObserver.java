package com.headclif.darkchat.server;

import Packets.OPacket;
import Packets.PacketManager;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientObserver extends Thread {
    private final Socket client;
    private String nickname;

    ClientObserver(Socket client) {
        this.client = client;
        start();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public void run() {
        while(true) {

            readData();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void readData() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            if (dis.available() <= 0)
                return;

            short id = dis.readShort();
            OPacket packet = PacketManager.getPacket(id);

            packet.read(dis);
            packet.handle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void invalidate() {
        Server.invalidate(client);
    }
}
