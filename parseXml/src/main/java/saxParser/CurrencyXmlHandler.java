package saxParser;

import model.Currency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CurrencyXmlHandler extends DefaultHandler {
    private static final String VALUTE = "Valute";
    private static final String NUMCODE = "NumCode";
    private static final String CHARCODE = "CharCode";
    private static final String NOMINAL = "Nominal";
    private static final String NAME = "Name";
    private static final String VALUE = "Value";
    private String elementValue;
    private Currency currency;
    private List<Currency> currencies;

    @Override
    public void startDocument() throws SAXException {
        currencies = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case VALUTE -> currency = new Currency();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case NUMCODE -> currency.setNumCode(elementValue);
            case CHARCODE -> currency.setCharCode(elementValue);
            case NOMINAL -> currency.setNominal(Integer.parseInt(elementValue));
            case NAME -> currency.setName(elementValue);
            case VALUE -> currency.setValue(new BigDecimal(elementValue.replace(",", ".")));
            case VALUTE -> currencies.add(currency);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    public List<Currency> currencies(){
        return currencies;
    }
}
