package Document;

import java.time.LocalDate;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.DocumentComponents.Date;

public class AcademicCalendar extends CompositeDocumentComponent {

    @Override
    public boolean matches(String content) {
        // only avalible for leaf classes
        return false;
    }

    public void addDate(LocalDate date, String description) {
        this.addComponent(new Date(date, description));
    }

}
