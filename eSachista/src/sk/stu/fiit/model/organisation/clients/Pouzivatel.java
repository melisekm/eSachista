package sk.stu.fiit.model.organisation.clients;

import java.util.Date;
import sk.stu.fiit.model.organisation.Organizacia;
import sk.stu.fiit.model.organisation.platform.Avatar;

/**
 *
 * @author Martin Melisek
 */
public abstract class Pouzivatel {

    protected Organizacia org;
    protected String meno;
    protected String login;
    private char[] password; //zahashovane heslo
    private Date datumRegistracie;
    private Avatar avatar;

    public Pouzivatel(String meno, String login, char[] password) {
        this.meno = meno;
        this.login = login;
        this.password = password;
        this.datumRegistracie = new Date();
    }

    public Pouzivatel(Organizacia org, String meno, String login, char[] password) {
        this.org = org;
        this.meno = meno;
        this.login = login;
        this.password = password;
    }

    public void updateDetails(Pouzivatel other) {
        this.meno = other.meno;
        this.org = other.org;
        this.avatar = other.avatar;
    }



    public Date getDatumRegistracie() {
        return datumRegistracie;
    }

    public void setDatumRegistracie(Date datumRegistracie) {
        this.datumRegistracie = datumRegistracie;
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

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

}
