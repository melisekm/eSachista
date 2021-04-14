package sk.stu.fiit.network.connections;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import sk.stu.fiit.network.connections.Connection;
import sk.stu.fiit.network.messages.Message;
import sk.stu.fiit.network.nodes.Server;

public class PlayerConnection extends Connection {

    private final Server parent;
    private String IpAddress;

    public PlayerConnection(Server parent, Socket socket) throws IOException {
        super(socket);
        this.parent = parent;
        this.IpAddress = this.getPlayerIP(socket);
    }

    private String getPlayerIP(Socket socket) {
        InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
        InetAddress inetAddress = ((InetSocketAddress) socketAddress).getAddress();
        return inetAddress.toString();
    }

    public void handleConnection() throws IOException, ClassNotFoundException {
        List<Message> recvdList = super.unpackMsg(this.parent);
        //int type = recvdList.get(0).getType();
        //String recvdData = recvdList.get(0).getMsg();
        //switch (type) {

        //}
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }
}
