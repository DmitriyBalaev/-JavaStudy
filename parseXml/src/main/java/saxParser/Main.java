package saxParser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser = spf.newSAXParser();

        CurrencyXmlHandler handler = new CurrencyXmlHandler();
        parser.parse("src/main/resources/test.xml", handler);

        handler.currencies().forEach(System.out::println);
    }
}
