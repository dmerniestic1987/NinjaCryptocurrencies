package ar.com.criptohugo.bean;

/**
 * Created by dmernies on 6/3/18.
 */

public class Ticker {
    private String firstLine;
    private String secondLine;

    public Ticker(){
        super();
        firstLine = "";
        secondLine = "";
    }

    public Ticker(String firstLine, String secondLine) {
        super();
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }
}
