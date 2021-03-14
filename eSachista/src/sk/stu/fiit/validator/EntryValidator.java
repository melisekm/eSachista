package sk.stu.fiit.validator;

import java.util.ArrayList;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;

/**
 *
 * @author Martin Melisek
 */
public class EntryValidator {

    public boolean checkUsernameRegistration(ArrayList<Pouzivatel> userDatabase, String login) {
        for (Pouzivatel p : userDatabase) {
            if (p.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUserLogin(ArrayList<Pouzivatel> userDatabase, String login, String password) {
        password = this.securePassword().stringToHash(password);
        for (Pouzivatel p : userDatabase) {
            String userPassword = this.securePassword().hashToString(p.getPassword());
            if (p.getLogin().equals(login) && userPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Hashable securePassword() {

        class Hash implements Hashable {

            private final int offset = 11;

            @Override
            public String hashToString(String hashed) {
                String result = ""; // pomocou posuvania znakov zahashuje
                for (int i = 0; i < hashed.length(); i++) {
                    char ch = (char) (hashed.charAt(i) - this.offset);
                    result += ch;
                }
                return result;
            }

            @Override
            public String stringToHash(String original) {
                String result = ""; // desifruje nakolko pozna aky bol posun
                for (int i = 0; i < original.length(); i++) {
                    char ch = (char) (original.charAt(i) + this.offset);
                    result += ch;
                }
                return result;
            }
        }
        return new Hash();
    }

}
