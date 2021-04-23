package sk.stu.fiit.model.organisation.clients;

import java.io.Serializable;

/**
 *
 * @author Martin Melisek
 */
public class Spravca extends Pouzivatel implements Serializable{

    private String email; // REGEX stuff

    public Spravca(Spravca other, String email) {
        super(other.meno, other.login, other.getPassword());
        this.email = email;
    }

    @Override
    public String toString() {
        return meno + " - Spravca";
    }
    
    

    public Spravca(String meno, String login, char[] password) {
        super(meno, login, password);
    }

    public Spravca(String meno, String login, char[] password, String email) {
        super(meno, login, password);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
