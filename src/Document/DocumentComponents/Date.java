package Document.DocumentComponents;

import java.time.LocalDateTime;

import Document.CompositeDocument.DocumentComponent;

public class Date implements DocumentComponent {
    private LocalDateTime date;

    private String id;

    public Date(String id, LocalDateTime date) {
        this.id = id;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }
}
