package Document.CompositeDocument;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Document.DocumentComponents.Date;

import Iterator.CompositeDocumentComponentIterator;
import Iterator.DocumentIterator;

public abstract class CompositeDocumentComponent implements DocumentComponent {
    private List<DocumentComponent> components = new ArrayList<>();

    public void addComponent(DocumentComponent component) {
        components.add(component);
    }

    public boolean removeComponent(DocumentComponent component) {
        return components.remove(component);
    }

    public void print() {
        for (DocumentComponent component : components) {
            component.print();
        }
    }

    public List<DocumentComponent> getComponents() {
        return Collections.unmodifiableList(components);

    }

    public DocumentIterator iterator() {
        return new CompositeDocumentComponentIterator(this);
    }

    public void updateDate(String id, LocalDate newDate) {
        for (DocumentComponent comp : components) {
            if (comp instanceof Date) {
                Date dateComp = (Date) comp;
                if (dateComp.getId().equals(id)) {
                    dateComp.setDate(newDate);
                    break;
                }
            }
        }
    }
 
}
