package Command;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

public class AddComponentCommand implements Command {
    private CompositeDocumentComponent document;
    private DocumentComponent component;

    public AddComponentCommand(CompositeDocumentComponent document, DocumentComponent component) {
        this.document = document;
        this.component = component;
    }

    @Override
    public void execute() {
        document.addComponent(component);
    }

    @Override
    public void undo() {
        document.removeComponent(component);
    }

    @Override
    public void redo() {
        execute();
    }
}
