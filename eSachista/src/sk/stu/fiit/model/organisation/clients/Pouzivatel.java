package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public abstract class Pouzivatel {
    private String meno;
    private String login;
    private String password; //zahashovane heslo

    public Pouzivatel(String meno, String login, String heslo) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
