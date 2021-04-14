package sk.stu.fiit.network.nodes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.network.connections.PlayerConnection;
import sk.stu.fiit.utils.NetworkConstants;

/**
 *
 * @author Martin Melisek
 */
public class Server extends Node {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private ServerSocket serverSocket;
    private ArrayList<PlayerConnection> playerConnections;
    private int port = NetworkConstants.PORT;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(port);// inicializacia server soketu na ktorom pocuva
            this.playerConnections = new ArrayList<>();
        } catch (IOException ex) {
            logger.error("Nastava chyba vytvarania servera.");
        }
    }

    private void handleConnections() {
        while (true) {
            try {
                Socket client = this.serverSocket.accept(); // klient sa pripojil
                this.initClient(client); // vytvor spojenie a cakaj na board
            } catch (IOException e) {
                logger.error("chyba pri vytvarani spojenia.");
                logger.error(e.getMessage());
            }
        }
    }

    public void closeAllConnections() {
        for (PlayerConnection con : playerConnections) {
            try {
                logger.info("Zatvaram spojenie s hracom " + con.getIpAddress());
                con.closeSocket();
            } catch (IOException e) {
                logger.error("Nepodarilo sa uzatvorit spojenie s " + con.getSocket().toString());
            }
        }
    }

    private void initClient(Socket sock) throws IOException {
        logger.info("client connected");
        PlayerConnection newPlayer = new PlayerConnection(this, sock);
        this.playerConnections.add(newPlayer);
        this.executor.execute(newPlayer); // vytvori thread a spusti run metodu
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        this.handleConnections();
    }

}
