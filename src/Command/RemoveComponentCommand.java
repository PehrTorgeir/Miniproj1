package Command;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

public class RemoveComponentCommand implements Command {
    private CompositeDocumentComponent document;
    private DocumentComponent component;

    public RemoveComponentCommand(CompositeDocumentComponent document, DocumentComponent component) {
        this.document = document;
        this.component = component;
    }

    @Override
    public void execute() {
        document.removeComponent(component);
    }

    @Override
    public void undo() {
        document.addComponent(component);
    }

    @Override
    public void redo() {
        execute();
    }
}
