package sk.stu.fiit.exceptions;

/**
 * exception pre organizacie, ktore prekrocia maximalny pocet turnajov na zaklade zvoleneho balika
 * @author Martin Melisek
 */
public class MaxPocetTurnajovException extends Exception{

    @Override
    public String getMessage() {
        return "Organizacia prekrocila maximalny pocet turnajov na zaklade balika"; 
    }
    
}
