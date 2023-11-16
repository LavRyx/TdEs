import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAXProcessor {
    public static void readXMLFile() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bName = false;
                boolean bAge = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Имя")) {
                        bName = true;
                    } else if (qName.equalsIgnoreCase("Возраст")) {
                        bAge = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (bName) {
                        System.out.println("Имя: " + new String(ch, start, length));
                        bName = false;
                    } else if (bAge) {
                        System.out.println("Возраст: " + new String(ch, start, length));
                        bAge = false;
                    }
                }
            };

            saxParser.parse("students.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
