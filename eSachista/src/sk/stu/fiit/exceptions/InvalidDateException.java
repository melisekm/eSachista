package sk.stu.fiit.exceptions;

/**
 *
 * @author Martin Melisek
 */
public class InvalidDateException extends Exception {

    @Override
    public String getMessage() {
        return "Organizator zvolil datum turnaja, ktory je v minulosti.";
    }
}
