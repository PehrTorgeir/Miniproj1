package Document.CompositeDocument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
}
