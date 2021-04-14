package sk.stu.fiit.network.connections;

import java.io.IOException;
import java.net.Socket;
import sk.stu.fiit.network.nodes.Client;

public class ServerConnection extends Connection {

    private Client parent;

    public ServerConnection(Client parent, Socket socket) throws IOException {
        super(socket);
        this.parent = parent;
    }

    public void handleConnection() throws IOException, ClassNotFoundException {
//        List<Message> recvdList = super.unpackMsg();
//        int type = recvdList.get(0).getType();
//        String recvdData = recvdList.get(0).getMsg();
//        String gameId;

    }
}
