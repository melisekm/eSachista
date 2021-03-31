package sk.stu.fiit.exceptions;

/**
 *
 * @author Martin Melisek
 */
public class MaxPocetTurnajovException extends Exception{

    @Override
    public String getMessage() {
        return "Organizacia prekrocila maximalny pocet turnajov na zaklade balika"; 
    }
    
}
