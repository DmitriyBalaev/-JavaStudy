package staxParser;

import saxParser.Currency;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyStaxParser {
    private static final String VALUTE = "Valute";
    private static final String NUMCODE = "NumCode";
    private static final String CHARCODE = "CharCode";
    private static final String NOMINAL = "Nominal";
    private static final String NAME = "Name";
    private static final String VALUE = "Value";

    public static List<Currency> currencies(String path) throws FileNotFoundException, XMLStreamException {
        List<Currency> currencies = new ArrayList<>();
        Currency currency = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));

        while (reader.hasNext()){
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement()){
                StartElement startElement = nextEvent.asStartElement();
                switch(startElement.getName().getLocalPart()){
                    case VALUTE -> currency = new Currency();
                    case NUMCODE -> {
                        nextEvent = reader.nextEvent();
                        currency.setNumCode(nextEvent.asCharacters().getData());
                    }
                    case CHARCODE -> {
                        nextEvent = reader.nextEvent();
                        currency.setCharCode(nextEvent.asCharacters().getData());
                    }
                    case NOMINAL -> {
                        nextEvent = reader.nextEvent();
                        currency.setNominal(Integer.parseInt(nextEvent.asCharacters().getData()));
                    }
                    case NAME -> {
                        nextEvent = reader.nextEvent();
                        currency.setName(nextEvent.asCharacters().getData());
                    }
                    case VALUE -> {
                        nextEvent = reader.nextEvent();
                        currency.setValue(new BigDecimal(nextEvent.asCharacters().getData().replace(",", ".")
                        ));
                    }
                }
            }
            if (nextEvent.isEndElement()){
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals(VALUTE)){
                    currencies.add(currency);
                }
            }
        }
        return currencies;
    }
}
