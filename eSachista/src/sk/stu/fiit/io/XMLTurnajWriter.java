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
import sk.stu.fiit.model.organisation.clients.Hrac;
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

    public XMLTurnajWriter(String nazovOrg, int idx) {
        super(nazovOrg);
        String turnajeDir = this.orgPath + "\\turnaje\\";
        new File(turnajeDir).mkdirs();
        String dir = turnajeDir + idx;
        logger.info("Zacinam generovat harmonogram " + dir);
        new File(dir).mkdirs();
        this.filePath = dir + "\\harmonogram.xml";
        logger.info("cesta " + this.filePath);
        this.saveOldXML(idx);
    }

    private void saveOldXML(int idx) {
        File directory = new File(this.orgPath + "\\turnaje\\" + idx + "\\historia\\");
        logger.info("ukladam kopiu stareho XML do priecinku=" + directory.getPath());
        directory.mkdirs();
        int fileCount = directory.list().length; // zisti kolko je suborov v priecinku

        String backupPath = directory.getPath() + "\\" + fileCount + ".xml";
        logger.info("ukladam kopiu stareho XML s nazvom " + backupPath);

        try ( BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
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
            logger.info("Zacinam zapisovat turnajove informacie do XML=" + this.filePath);
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

            LinkedHashMap<Integer, Integer> zapasy = turnaj.getStage().getParovanie();

            for (Map.Entry<Integer, Integer> zapas : zapasy.entrySet()) {
                int prvyHracId = zapas.getKey();
                int druhyHracId = zapas.getValue();
                String prvyHracStr = String.valueOf(prvyHracId);
                String druhyHracStr = String.valueOf(druhyHracId);

                Zapas newZapas = new Zapas();
                String casZacatiaZapasu = this.getCasZacatiaZapasu(newZapas);

                boolean freeWinPreP2 = prvyHracId == -1;
                boolean freeWinPreP1 = druhyHracId == -1;
                boolean FWvsFW = Boolean.logicalAnd(freeWinPreP1, freeWinPreP2);
                Hrac hrac1 = null;
                Hrac hrac2 = null;
                if (!FWvsFW) {
                    if (freeWinPreP2) {
                        hrac2 = turnaj.getHraci().get(druhyHracId);
                    } else if (freeWinPreP1) {
                        hrac1 = turnaj.getHraci().get(prvyHracId);
                    } else {
                        hrac1 = turnaj.getHraci().get(prvyHracId);
                        hrac2 = turnaj.getHraci().get(druhyHracId);
                    }
                }
                newZapas.setHrac1(hrac1);
                newZapas.setHrac2(hrac2);

                newZapas.setTurnaj(turnaj);

                zapasyElement.appendChild(createZapas(doc, casZacatiaZapasu, prvyHracStr, druhyHracStr, "-1", newZapas));
                if (hrac1 != null) {
                    turnaj.getHraci().get(prvyHracId).getZapasy().add(newZapas);
                }
                if (hrac2 != null) {
                    turnaj.getHraci().get(druhyHracId).getZapasy().add(newZapas);
                }
                turnaj.getZapasy().put(newZapas, turnaj.getStage().getKolo() - 1);
            }
            for (Map.Entry<Zapas, Integer> entry : turnaj.getZapasy().entrySet()) {
                Zapas key = entry.getKey();
                Integer value = entry.getValue();
                logger.debug("Zapas: = " + key);
                logger.debug("Kolo = " + value);
            }

            // for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            // write to console or file
            StreamResult file = new StreamResult(new File(this.filePath));
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
            z.setHrac2Figurky(FarbaFiguriek.BIELA);
        } else {
            zapasElement.appendChild(createZapasDetails(doc, "biely", hrac1));
            zapasElement.appendChild(createZapasDetails(doc, "cierny", hrac2));
            z.setHrac1Figurky(FarbaFiguriek.CIERNA);
            z.setHrac2Figurky(FarbaFiguriek.BIELA);
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
