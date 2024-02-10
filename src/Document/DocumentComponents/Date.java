package Document.DocumentComponents;

import java.time.LocalDate;

import Document.CompositeDocument.DocumentComponent;

public class Date implements DocumentComponent {
    private LocalDate date;
    private String description;

    public Date(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    @Override
    public void print() {
        // Implement printing logic for dates
    }

    @Override
    public boolean matches(String criterion) {
        
        return description.equalsIgnoreCase(criterion);
    }
}
