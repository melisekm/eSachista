package sk.stu.fiit.service;

import sk.stu.fiit.database.Database;

/**
 *
 * @author Martin Melisek
 */
public abstract class Service {

    protected Database db;

    public Service() {
        this.db = Database.getInstance();
    }

}
