package sk.stu.fiit.exceptions;

/**
 * exception pre turnaje ktore su vytvorene v minulosti.
 * @author Martin Melisek
 */
public class InvalidDateException extends Exception {

    @Override
    public String getMessage() {
        return "Organizator zvolil datum turnaja, ktory je v minulosti.";
    }
}
