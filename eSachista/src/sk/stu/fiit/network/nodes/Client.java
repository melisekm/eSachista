package sk.stu.fiit.network.nodes;

import java.io.IOException;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.network.connections.Connection;
import sk.stu.fiit.network.connections.ServerConnection;
import sk.stu.fiit.utils.NetworkConstants;

/**
 *
 * @author Martin Melisek
 */
public class Client extends Node {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    private Connection serverConnection;
    private String ip = NetworkConstants.IP_ADDRESS;
    private int port = NetworkConstants.PORT;

    public Client() {
    }

    public void initConnection(String ip, int port) throws IOException {
        // socket ktorym komunikujeme so serverom
        Socket socket = new Socket(ip, port); // inicializacia soketu IP servera a port na akom pocuva
        this.serverConnection = new ServerConnection(this, socket);
        this.executor.execute(serverConnection); // vytvori thread a spusti run metodu
    }

    @Override
    public void run() {
        try {
            this.initConnection(this.ip, this.port);
        } catch (IOException ex) {
            logger.error("Nepodarilo sa pripojit na server.");
        }
    }

    public void closeConnection() {
        if (this.serverConnection == null) {
            return;
        }
        try {
            this.serverConnection.closeSocket();
        } catch (IOException ex) {
            logger.error("Nepodarilo sa ukoncit spojenie so serverom.");
        }
    }

    public Connection getServerConnection() {
        return serverConnection;
    }

    public void setServerConnection(Connection serverConnection) {
        this.serverConnection = serverConnection;
    }

}
