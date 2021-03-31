package sk.stu.fiit.model.organisation.clients;

import sk.stu.fiit.model.organisation.Organizacia;

/**
 *
 * @author Martin Melisek
 */
public abstract class Pouzivatel {

    protected boolean firstLogin = false;
    protected Organizacia org;
    protected String meno;
    protected String login;
    private char[] password; //zahashovane heslo

    public Pouzivatel(String meno, String login, char[] password) {
        this.meno = meno;
        this.login = login;
        this.password = password;
    }

    public Pouzivatel(Organizacia org, String meno, String login, char[] password) {
        this.org = org;
        this.meno = meno;
        this.login = login;
        this.password = password;
    }

    public Organizacia getOrg() {
        return org;
    }

    public void setOrg(Organizacia org) {
        this.org = org;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
