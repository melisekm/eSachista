package sk.stu.fiit.io;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * toto teda potrebuje kontrolu XD malo by sa spustit ked zada Spravca zada
 * vysledok
 *
 * @author Martin Melisek
 */
public class XMLTurnajModifier extends XMLTurnajHandler {

    private static final Logger logger = LoggerFactory.getLogger(XMLTurnajReader.class);

    public XMLTurnajModifier(String xmlPath) {
        super(xmlPath);
    }

    public void modifyXML(String hracId, String vyherca) {
        logger.info("spusam modifikaciu suboru " + this.xmlPath);
        File xmlFile = new File(this.xmlPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            // parse xml file and load into document
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            // update Element value
            updateElementValue(doc, hracId, vyherca);

            // write the updated document to file or console
            logger.info("Zapisujem zmodifikovany subor");
            writeXMLFile(doc);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException ex) {
            logger.error(ex.getMessage());
        }
    }

    private void updateElementValue(Document doc, String hracId, String vyherca) {
        NodeList zapasyXML = doc.getElementsByTagName("zapas");
        Element zapasElement = null;

        for (int i = 0; i < zapasyXML.getLength(); i++) {
            zapasElement = (Element) zapasyXML.item(i);
            String hrac1 = zapasElement.getElementsByTagName("cierny").item(0).getTextContent();
            String hrac2 = zapasElement.getElementsByTagName("biely").item(0).getTextContent();
            if (hrac1.equals(hracId) || hrac2.equals(hracId)) { // cierny alebo biely
                Node vyhercaXML = zapasElement.getElementsByTagName("vyherca").item(0).getFirstChild();
                vyhercaXML.setNodeValue(vyherca);
                logger.info("nasiel som zhodu ktoru budem modifikovat");
                break;
            }
        }
    }

    private void writeXMLFile(Document doc)
            throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);

        StreamResult streamResult = new StreamResult(new File(this.xmlPath));
        transformer.transform(domSource, streamResult);
    }

}
