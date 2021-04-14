package sk.stu.fiit.network.connections;

import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.stu.fiit.network.messages.Message;
import sk.stu.fiit.network.nodes.Server;

/**
 *
 * @author Martin Melisek
 */
public abstract class Connection implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Connection.class);

    private Socket socket;
    public ObjectInputStream in;
    public ObjectOutputStream out;

    protected Connection(Socket socket) throws IOException {
        try {
            socket.setSoTimeout(0);
            socket.setKeepAlive(true);
        } catch (SocketException e) {
            logger.error(e.getStackTrace().toString());
        }
        this.socket = socket;

        this.out = new ObjectOutputStream(this.socket.getOutputStream());
        this.in = new ObjectInputStream(this.socket.getInputStream());
    }

    @Override
    public void run() {
        while (!this.socket.isClosed()) {
            try {
                this.handleConnection();
            } catch (IOException e) {
                logger.info("Hrac sa odpojil - socket bol uzatvoreny.");
                break;
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            }
        }
        try { // loop bol breaknuty alebo niekto ukoncil spojenie
            logger.info("Zatvaram spojenie.");
            this.closeSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void handleConnection() throws IOException, ClassNotFoundException;

    public List<Message> unpackMsg(Server server) throws ClassNotFoundException, IOException {
        try {
            return (List<Message>) this.in.readObject();
        } catch (IOException e) { //odpojil sa
            //server.removePlayer((PlayerConnection) this); TODO
            throw (e);
        }
    }

    public List<Message> unpackMsg() throws ClassNotFoundException, IOException {
        return (List<Message>) this.in.readObject();
    }

    public void closeSocket() throws IOException {
        if (!this.socket.isClosed()) { // ak este nebol zavrety tak ho zavrie
            this.socket.close();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
