package sk.stu.fiit.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class XMLTurnajWriter extends XMLTurnajHandler{

    private static final Logger logger = LoggerFactory.getLogger(XMLTurnajWriter.class);


    public XMLTurnajWriter(String path, int idx) {
        super(path);
        this.saveOldXML(idx);
    }

    private void saveOldXML(int idx) {
        File directory = new File("resources/turnaje/" + idx + "historia/");
        int fileCount = directory.list().length; // zisti kolko je suborov v priecinku
        String backupPath = "resources/turnaje/" + idx + "historia/" + fileCount + ".xml";
        try ( BufferedReader br = new BufferedReader(new FileReader(this.xmlPath))) {
            String tmpText;
            try ( BufferedWriter objBW = new BufferedWriter(new FileWriter(backupPath))) {
                while ((tmpText = br.readLine()) != null) {
                    objBW.write(tmpText + "\n");
                }
            }
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void writeTurnaj(Turnaj turnaj) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);

            Element turnajElement = doc.createElement("turnaj");
            turnajElement.setAttribute("id", "1");
            root.appendChild(turnajElement);

            Element zapasyElement = doc.createElement("zapasy");
            turnajElement.appendChild(zapasyElement);

            LinkedHashMap<Integer, Integer> zapasy = turnaj.getStage().getZapasy();
            String casZacatiaZapasu = this.getCasZacatiaZapasu();
            for (Map.Entry<Integer, Integer> zapas : zapasy.entrySet()) {
                String prvyHrac = String.valueOf(zapas.getKey());
                String druhyHrac = String.valueOf(zapas.getValue());
                zapasyElement.appendChild(createZapas(doc, casZacatiaZapasu, prvyHrac, druhyHrac, "-1"));
            }

            // for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // write to console or file
            StreamResult file = new StreamResult(new File(this.xmlPath));
            // write data
            transformer.transform(source, file);

        } catch (Exception ex) {
            logger.error("CHYBA PRI ZAPISOVANI DO XML.");
            logger.error(ex.getMessage());
        }

    }

    private Node createZapas(Document doc, String datum, String hrac1, String hrac2, String vyherca) {
        Element zapas = doc.createElement("zapas");

        zapas.appendChild(createZapasDetails(doc, "datum", datum));
        if (Math.random() < 0.5) {
            zapas.appendChild(createZapasDetails(doc, "cierny", hrac1));
            zapas.appendChild(createZapasDetails(doc, "biely", hrac2));
        } else {
            zapas.appendChild(createZapasDetails(doc, "biely", hrac1));
            zapas.appendChild(createZapasDetails(doc, "cierny", hrac2));

        }
        zapas.appendChild(createZapasDetails(doc, "vyherca", vyherca));

        return zapas;
    }

    // utility method to create text node
    private Node createZapasDetails(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private String getCasZacatiaZapasu() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 5);
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(cal.get(Calendar.MINUTE));
    }
}
