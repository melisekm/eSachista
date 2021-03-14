package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public class Spravca extends Pouzivatel {

    private String email; // REGEX stuff

    public Spravca(Spravca other) {
        super(other.meno, other.login, other.getPassword());
        this.email = other.email;
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

    @Override
    public String toString() {
        return "Správca\n" + "Meno: " + meno + "\nLogin: " + login + "\n";
    }

}
