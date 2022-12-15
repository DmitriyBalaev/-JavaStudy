package saxParser;

import java.math.BigDecimal;

public class Currency {
    private String numCode;
    private String charCode;
    private Integer Nominal;
    private String name;
    private BigDecimal value;

    public Currency() {
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return Nominal;
    }

    public void setNominal(int nominal) {
        Nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", Nominal=" + Nominal +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
