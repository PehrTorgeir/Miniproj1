package Document.DocumentComponents;

import java.time.LocalDate;

import Document.CompositeDocument.DocumentComponent;

public class Date implements DocumentComponent {
    private LocalDate date;
    private String description;
    private String id;

    public Date(String id, LocalDate date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }

    @Override
    public void print() {
        System.out.println("Date: " + date + " booking: " + description);
    }

    @Override
    public boolean matches(String criterion) {

        return id.equals(criterion);
    }
}
