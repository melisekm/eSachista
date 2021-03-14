package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public class Spravca extends Pouzivatel {

    private String email; // REGEX stuff

    public Spravca(String meno, String login, char[] heslo) {
        super(meno, login, heslo);
    }

    public Spravca(String meno, String login, char[] heslo, String email) {
        super(meno, login, heslo);
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
