package sk.stu.fiit.io;

/**
 *
 * @author Martin Melisek
 */
public class XMLTurnajHandler {

    private String baseDir = "resources\\";
    protected String orgPath;
    protected String filePath;


    public XMLTurnajHandler(String nazov) {
        this.orgPath = this.baseDir + nazov + "\\";
    }

}
