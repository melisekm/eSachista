package sk.stu.fiit.service;

import sk.stu.fiit.database.Database;
import sk.stu.fiit.network.nodes.Client;
import sk.stu.fiit.network.nodes.Server;

/**
 *
 * @author Martin Melisek
 */
public abstract class Service {

    protected Client client;
    protected Server server;

    public Service() {
    }

    public Database getDb() {
        return Database.getInstance();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

}
