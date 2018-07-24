package Message;

public class ClientMessage extends Message {
    private short id;
    private String login;
    private String[] messages;
    private Double[] doubles;
    private Integer[] numbers;

    private int stringCounter = 0;

    public ClientMessage(short id, String data) {
        this.id = id;
    };

    @Override
    public short getID() {
        return id;
    }
}
