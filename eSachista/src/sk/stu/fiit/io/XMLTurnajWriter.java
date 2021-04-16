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
import sk.stu.fiit.model.organisation.platform.FarbaFiguriek;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 * Toto je bohuzial ten najneprehladnejsi kod aky som kedy napisal naraz sa tu
 * vytvara a setuje zapas pre hracov lebo toto je z nejakeho dovodu <br>
 * jediny moment ked mam v spravcoskom ucte k dispozii vsetky udaje naraz.
 *
 * @author Martin Melisek
 */
public class XMLTurnajWriter extends XMLTurnajHandler {

    private static final Logger logger = LoggerFactory.getLogger(XMLTurnajWriter.class);

    public XMLTurnajWriter(String path, int idx) {
        super(path);
        this.saveOldXML(idx);
    }

    private void saveOldXML(int idx) {
        File directory = new File("resources\\turnaje\\" + idx + "\\historia\\");
        logger.info("ukladam kopiu stareho XML do suboru=" + directory.getPath());
        directory.mkdirs();
        int fileCount = directory.list().length; // zisti kolko je suborov v priecinku

        String backupPath = directory.getPath() + "\\" + fileCount + ".xml";
        logger.info("ukladam kopiu stareho XML s nazvom " + backupPath);

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
            logger.info("Zacinam zapisovat turnajove informacie do XML=" + this.xmlPath);
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
            Zapas newZapas = new Zapas();
            String casZacatiaZapasu = this.getCasZacatiaZapasu(newZapas);
            
            for (Map.Entry<Integer, Integer> zapas : zapasy.entrySet()) {
                String prvyHrac = String.valueOf(zapas.getKey());
                String druhyHrac = String.valueOf(zapas.getValue());

                newZapas.setHrac1(turnaj.getHraci().get(zapas.getKey()));
                newZapas.setHrac2(turnaj.getHraci().get(zapas.getValue()));
                newZapas.setTurnaj(turnaj);

                zapasyElement.appendChild(createZapas(doc, casZacatiaZapasu, prvyHrac, druhyHrac, "-1", newZapas));

                turnaj.getHraci().get(zapas.getKey()).getZapasy().add(newZapas);
                turnaj.getHraci().get(zapas.getValue()).getZapasy().add(newZapas);
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

    private Node createZapas(Document doc, String datum, String hrac1, String hrac2, String vyherca, Zapas z) {
        Element zapasElement = doc.createElement("zapas");

        zapasElement.appendChild(createZapasDetails(doc, "datum", datum));
        if (Math.random() < 0.5) {
            zapasElement.appendChild(createZapasDetails(doc, "cierny", hrac1));
            zapasElement.appendChild(createZapasDetails(doc, "biely", hrac2));
            z.setHrac1Figurky(FarbaFiguriek.CIERNA);
            z.setHrac1Figurky(FarbaFiguriek.BIELA);
        } else {
            zapasElement.appendChild(createZapasDetails(doc, "biely", hrac1));
            zapasElement.appendChild(createZapasDetails(doc, "cierny", hrac2));
            z.setHrac1Figurky(FarbaFiguriek.CIERNA);
            z.setHrac1Figurky(FarbaFiguriek.BIELA);
        }
        zapasElement.appendChild(createZapasDetails(doc, "vyherca", vyherca));

        return zapasElement;
    }

    // utility method to create text node
    private Node createZapasDetails(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private String getCasZacatiaZapasu(Zapas newZapas) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 5);
        newZapas.setCasZaciatku(cal.getTime());
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(cal.get(Calendar.MINUTE));
    }
}
