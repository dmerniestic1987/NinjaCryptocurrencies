package criptohugo.com.ar.a1942;

/**
 * Created by dmernies on 4/3/18.
 */

public class ExampleBean {
    private Long id;
    private String firstLine;
    private String secondLine;

    public ExampleBean(String firstLine, String secondLine) {
        this();
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public ExampleBean(){
        super();
        this.id = System.currentTimeMillis();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExampleBean{" +
                "id=" + id +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                '}';
    }
}
