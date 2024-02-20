package Command;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

public class EditComponentCommand implements Command {
    private Command addCommand;
    private Command removeCommand;

    public EditComponentCommand(CompositeDocumentComponent document, DocumentComponent oldComponent,
            DocumentComponent newComponent) {
        this.addCommand = new AddComponentCommand(document, newComponent);
        this.removeCommand = new RemoveComponentCommand(document, oldComponent);
    }

    @Override
    public void execute() {
        
        removeCommand.execute();
        
        addCommand.execute();
    }

    @Override
    public void undo() {
        
        addCommand.undo();
        
        removeCommand.undo();
    }

    @Override
    public void redo() {
        // Redo the edit by executing the commands again
        removeCommand.execute();
        addCommand.execute();
    }

}
