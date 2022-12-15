package staxParser;

import model.Currency;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        String path = "src/main/resources/test.xml";
        List<Currency> currencies = CurrencyStaxParser.currencies(path);

        currencies.forEach(System.out::println);
    }
}
