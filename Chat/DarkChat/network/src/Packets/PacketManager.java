package Packets;

import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;

public class PacketManager {

    private final static Map<Short, Class<? extends OPacket>> packets = new HashMap<>();

    static {

    }

    public static OPacket getPacket(short id) {
        try {
            return packets.get(id).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void read(short id, DataInputStream dis) {
        try {
            OPacket packet = packets.get(id).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
