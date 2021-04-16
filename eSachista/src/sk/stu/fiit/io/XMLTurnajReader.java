package sk.stu.fiit.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sk.stu.fiit.model.organisation.clients.Hrac;
import sk.stu.fiit.model.organisation.platform.FarbaFiguriek;
import sk.stu.fiit.model.organisation.platform.Zapas;
import sk.stu.fiit.model.organisation.platform.turnaj.Turnaj;

/**
 *
 * @author Martin Melisek
 */
public class XMLTurnajReader {

    private String xmlPath;

    public XMLTurnajReader(String path) {
        this.xmlPath = path;
    }

    public ArrayList<Zapas> parseTurnaj(ArrayList<Hrac> hraci, Turnaj prebiehajuciTurnaj) {
        File xmlFile = new File(this.xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList zapasyXML = doc.getElementsByTagName("zapas");

            return this.parseZapasy(zapasyXML, hraci, prebiehajuciTurnaj);

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private ArrayList<Zapas> parseZapasy(NodeList zapasyXML, ArrayList<Hrac> hraci, Turnaj prebiehajuciTurnaj) {
        ArrayList<Zapas> zapasy = new ArrayList<>();

        for (int xmlID = 0; xmlID < zapasyXML.getLength(); xmlID++) {

            Node zapasXML = zapasyXML.item(xmlID);
            if (zapasXML.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element zapasElement = (Element) zapasXML;
            Zapas z = parseZapas(zapasElement, hraci, prebiehajuciTurnaj);
            zapasy.add(z);

        }
        return zapasy;
    }

    private Zapas parseZapas(Element zapasElement, ArrayList<Hrac> hraci, Turnaj prebiehajuciTurnaj) {
        Date casZaciatku = this.getCasZaciatku(zapasElement, prebiehajuciTurnaj.getDatumKonania());

        int hrac1Id = Integer.parseInt(zapasElement.getElementsByTagName("cierny").item(0).getTextContent());
        Hrac h1 = hraci.get(hrac1Id);
        FarbaFiguriek h1Farba = FarbaFiguriek.CIERNA;

        int hrac2Id = Integer.parseInt(zapasElement.getElementsByTagName("biely").item(0).getTextContent());
        Hrac h2 = hraci.get(hrac2Id);
        FarbaFiguriek h2Farba = FarbaFiguriek.BIELA;

        int vyhercaId = Integer.parseInt(zapasElement.getElementsByTagName("vyherca").item(0).getTextContent());
        Hrac vyherca = null;
        if (vyhercaId != -1) {
            vyherca = hraci.get(vyhercaId);
        }

        return new Zapas(prebiehajuciTurnaj, h1, h2, casZaciatku, h1Farba, h2Farba, vyherca);
    }

    private Date getCasZaciatku(Element element, Date datumTurnaja) {
        String datumString = element.getElementsByTagName("datum").item(0).getTextContent();
        Date casZaciatku = datumTurnaja;
        Calendar cal = Calendar.getInstance();
        cal.setTime(casZaciatku);
        String[] cas = datumString.split(":");
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(cas[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(cas[1]));
        casZaciatku = cal.getTime();
        return casZaciatku;
    }

}
