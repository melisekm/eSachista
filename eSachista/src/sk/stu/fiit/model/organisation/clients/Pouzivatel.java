package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public abstract class Pouzivatel {
    protected String meno;
    protected String login;
    private char[] password; //zahashovane heslo

    public Pouzivatel(String meno, String login, char[] heslo) {
        this.meno = meno;
        this.login = login;
        this.password = heslo;
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
