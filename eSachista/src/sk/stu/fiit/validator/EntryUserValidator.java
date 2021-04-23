package sk.stu.fiit.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.stu.fiit.model.organisation.clients.Pouzivatel;

/**
 *
 * @author Martin Melisek
 */
public class EntryUserValidator {

    public boolean checkUsernameAvailability(ArrayList<Pouzivatel> userDatabase, String login) {
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

    /**
     * Zvaliduje emailovu adresu podla nasledujuceho patternu<br>
     * slovo sa zacina na: pismeno cislo . _ % + alebo -, ktore sa vyskytuje 1 a viac krat<br>
     * nasleduje zavinac za nim jeden a viac krat pismeno cislo . -<br>
     * nasleduje bodka za nou pismeno 2 az 6 krat a EOF.<br>
     * nezalezi na velkosti pismen.<br>
     * @param email ktory sa ma zvalidovat
     * @return true ak je validny, false ak nie
     */
    public boolean validateEmail(String email) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
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
