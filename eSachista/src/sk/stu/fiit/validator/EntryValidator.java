package sk.stu.fiit.validator;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Pouzivatel checkUserLogin(ArrayList<Pouzivatel> userDatabase, String login, char[] password) {
        password = this.securePassword().stringToHash(password);
        for (Pouzivatel p : userDatabase) {
            if (p.getLogin().equals(login) && Arrays.equals(p.getPassword(), password)) {
                return p;
            }
        }
        return null;
    }

    public Hashable securePassword() {

        class Hash implements Hashable {

            private final int offset = 11;

            @Override
            public char[] hashToString(char[] hashed) {
                char[] result = new char[hashed.length];// pomocou posuvania znakov zahashuje
                for (int i = 0; i < hashed.length; i++) {
                    result[i] = (char) (hashed[i] - this.offset);
                }
                return result;
            }

            @Override
            public char[] stringToHash(char[] original) {
                char[] result = new char[original.length]; // desifruje nakolko pozna aky bol posun
                for (int i = 0; i < original.length; i++) {
                    result[i] = (char) (original[i] + this.offset);
                }
                return result;
            }
        }
        return new Hash();
    }

}
