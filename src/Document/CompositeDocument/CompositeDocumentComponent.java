package Document.CompositeDocument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Iterator.CompositeDocumentComponentIterator;
import Iterator.DocumentIterator;

public abstract class CompositeDocumentComponent implements DocumentComponent {
    private List<DocumentComponent> components = new ArrayList<>();

    public void addComponent(DocumentComponent component) {
        components.add(component);
    }

    public void removeComponent(DocumentComponent component) {
        components.remove(component);
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

}
