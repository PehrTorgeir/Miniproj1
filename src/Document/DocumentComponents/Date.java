package Document.DocumentComponents;

import java.time.LocalDate;

import Document.CompositeDocument.DocumentComponent;

public class Date implements DocumentComponent {
    private LocalDate date;

    private String id;

    public Date() {

    }

    public Date(LocalDate date) {

        this.date = date;

    }

    @Override
    public void print() {
        System.out.println("Date: " + date);
    }

    @Override
    public boolean matches(String criterion) {

        return id.equals(criterion);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toHtml() {
        return "<label>" + this.date + "</label>";
    }


    @Override
    public String toMarkdown() {
        return date.toString(); 
    }
}
