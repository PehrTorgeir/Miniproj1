package Document.Facade;

import Command.AddComponentCommand;
import Command.AddRowCommand;
import Command.Command;
import Command.DocumentCommandManager;
import Command.EditComponentCommand;
import Command.RemoveComponentCommand;
import Document.DocumentType;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

import Document.DocumentComponents.DocumentComponentType;
import Document.DocumentComponents.Matrix;
import Document.DocumentComponents.Table;
import Factory.ConcreteDocumentFactory;
import Factory.DocumentComponentFactory;
import Iterator.CompositeDocumentComponentIterator;

public class DocumentFacade {
    private final ConcreteDocumentFactory factory;
    private DocumentComponentFactory componentFactory;
    private CompositeDocumentComponentIterator iterator;
    private DocumentCommandManager commandManager;

    public DocumentFacade() {
        this.factory = new ConcreteDocumentFactory();
        this.componentFactory = new DocumentComponentFactory();
        this.commandManager = new DocumentCommandManager();

    }

    public CompositeDocumentComponent createDocument(DocumentType documentType) {
        CompositeDocumentComponent Document = factory.createDocument(documentType);
        return Document;
    }

    public void addComponent(CompositeDocumentComponent document, DocumentComponentType type, String... content) {
        boolean idExists = document.getComponents().stream()
                .anyMatch(c -> c.matches(content[0]));
        if (idExists) {
            throw new IllegalArgumentException("A component with ID '" + content[0] + "' already exists.");
        } else {
            DocumentComponent component = componentFactory.createComponent(type, content);
            Command addCommand = new AddComponentCommand(document, component);
            commandManager.executeCommand(addCommand);
        }

    }

    public void removeComponent(CompositeDocumentComponent document, String identifier) {

        DocumentComponent componentToRemove = document.getComponents().stream()
                .filter(c -> c.matches(identifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Component not found."));

        Command removeCommand = new RemoveComponentCommand(document, componentToRemove);

        commandManager.executeCommand(removeCommand);
    }

    public void editComponent(CompositeDocumentComponent document, String oldIdentifier, DocumentComponentType newType,
            String newContent) {

        DocumentComponent oldComponent = document.getComponents().stream()
                .filter(c -> c.matches(oldIdentifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Old component not found"));

        DocumentComponent newComponent = componentFactory.createComponent(newType, newContent);

        EditComponentCommand editCommand = new EditComponentCommand(document, oldComponent, newComponent);
        commandManager.executeCommand(editCommand);
    }

    public void undoLastAction() {
        commandManager.undo();
    }

    public void redoLastAction() {
        commandManager.redo();
    }

    public void printDocument(CompositeDocumentComponent component) {
        iterator = new CompositeDocumentComponentIterator(component);
        while (iterator.hasNext()) {
            DocumentComponent iteratorComponent = iterator.next();
            iteratorComponent.print();

        }

    }

    public String buildHtmlDocument(CompositeDocumentComponent document) {
        return document.toHtml();
    }

    public String buildMarkdownDocument(CompositeDocumentComponent document) {
        return document.toMarkdown();
    }

    public void addRowToMatrix(CompositeDocumentComponent document, String matrixId, double... rowData) {
        for (DocumentComponent component : document.getComponents()) {
            if (component instanceof Matrix && ((Matrix) component).getId().equals(matrixId)) {
                ((Matrix) component).addRow(rowData);
                return;
            }
        }
        throw new IllegalArgumentException("Matrix with ID " + matrixId + " not found.");
    }


    public void addRowToTable(CompositeDocumentComponent document, String tableId, String... rowData) {
        Table table = findTableById(document, tableId);
        if (table != null) {
            Command addRowCommand = new AddRowCommand(table, rowData);
            commandManager.executeCommand(addRowCommand);
        } else {
            throw new IllegalArgumentException("Table with ID '" + tableId + "' not found.");
        }
    }

    private Table findTableById(CompositeDocumentComponent document, String tableId) {
        for (DocumentComponent component : document.getComponents()) {
            if (component instanceof Table && ((Table) component).getId().equals(tableId)) {
                return (Table) component;
            }
        }
        return null; 
    }

}