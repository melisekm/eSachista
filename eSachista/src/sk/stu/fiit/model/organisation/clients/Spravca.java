package sk.stu.fiit.model.organisation.clients;

/**
 *
 * @author Martin Melisek
 */
public class Spravca extends Pouzivatel {

    private String email; // REGEX stuff

    public Spravca(String meno, String login, String heslo, String email) {
        super(meno, login, heslo);
        this.email = email;
    }

}
