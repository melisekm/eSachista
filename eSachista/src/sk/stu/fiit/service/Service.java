package sk.stu.fiit.service;

import sk.stu.fiit.database.Database;

/**
 *
 * @author Martin Melisek
 */
public abstract class Service {

    public Service() {
    }

    public Database getDb() {
        return Database.getInstance();
    }
    
}
