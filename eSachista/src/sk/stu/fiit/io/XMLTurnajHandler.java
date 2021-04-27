package sk.stu.fiit.io;

/**
 * Abstraktna trieda pre XML citanie/zapisovanie/modifikovanie, vyuziva DOM
 * @author Martin Melisek
 */
public abstract class XMLTurnajHandler {

    private String baseDir = "resources\\";
    protected String orgPath;
    protected String filePath;


    public XMLTurnajHandler(String nazov) {
        this.orgPath = this.baseDir + nazov + "\\";
    }

}
