package Document.Facade;

import Command.AddComponentCommand;
import Command.Command;
import Command.DocumentCommandManager;
import Command.EditComponentCommand;
import Command.RemoveComponentCommand;
import Document.DocumentType;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

import Document.DocumentComponents.DocumentComponentType;
import Document.DocumentConverter.HtmlBuilder;
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
        // Find the component to remove
        DocumentComponent componentToRemove = document.getComponents().stream()
                .filter(c -> c.matches(identifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Component not found."));

        // Create a command to remove the component
        Command removeCommand = new RemoveComponentCommand(document, componentToRemove);

        // Execute the command through the command manager
        commandManager.executeCommand(removeCommand);
    }

    public void editComponent(CompositeDocumentComponent document, String oldIdentifier, DocumentComponentType newType,
            String newContent) {
        // Find the old component based on its identifier
        DocumentComponent oldComponent = document.getComponents().stream()
                .filter(c -> c.matches(oldIdentifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Old component not found"));

        // Create the new component based on the new type and content
        DocumentComponent newComponent = componentFactory.createComponent(newType, newContent);

        // Create and execute the edit command
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
        HtmlBuilder builder = new HtmlBuilder();
        for (DocumentComponent component : document.getComponents()) {
            builder.addComponent(component);
        }
        return builder.build();
    }

}
/*
 * // used for removing title,paragraph or author only.
 * public void removeComponent(CompositeDocumentComponent document, String
 * content) {
 * DocumentComponent componentToRemove = document.getComponents().stream()
 * .filter(c -> c.matches(content))
 * .findFirst()
 * .orElse(null);
 * 
 * if (componentToRemove != null) {
 * document.removeComponent(componentToRemove);
 * }
 * }
 */
/*
 * public DocumentComponent createDocumentComponent(CompositeDocumentComponent
 * document,
 * DocumentComponentType documentType) {
 * 
 * DocumentComponent documentComponent =
 * componentFactory.createComponent(documentType);
 * document.addComponent(documentComponent);
 * return documentComponent;
 * }
 * 
 * public void addTitle(CompositeDocumentComponent document, DocumentComponent
 * documentComponent, String titleText) {
 * if (documentComponent instanceof Title) {
 * ((Title) documentComponent).setTitle(titleText);
 * command = new AddComponentCommand(document, documentComponent);
 * command.execute();
 * 
 * } else {
 * throw new
 * IllegalArgumentException("Invalid documentComponent type: this is not a title"
 * );
 * }
 * 
 * }
 */

/*
 * public void updateTitle(CompositeDocumentComponent document, String newTitle)
 * {
 * 
 * document.getComponents().stream()
 * .filter(c -> c instanceof Title)
 * .findFirst()
 * .ifPresent(document::removeComponent);
 * 
 * document.addComponent(new Title(newTitle));
 * }
 * 
 * public void addParagraph(CompositeDocumentComponent document, String
 * paragraphText) {
 * document.addComponent(new Paragraph(paragraphText));
 * }
 * 
 * public void updateAuthor(CompositeDocumentComponent document, String
 * newAuthor) {
 * 
 * document.getComponents().stream()
 * .filter(c -> c instanceof Author)
 * .findFirst()
 * .ifPresent(document::removeComponent);
 * 
 * document.addComponent(new Author(newAuthor));
 * }
 * 
 * // used for removing title,paragraph or author only.
 * public void removeComponent(CompositeDocumentComponent document, String
 * content) {
 * DocumentComponent componentToRemove = document.getComponents().stream()
 * .filter(c -> c.matches(content))
 * .findFirst()
 * .orElse(null);
 * 
 * if (componentToRemove != null) {
 * document.removeComponent(componentToRemove);
 * }
 * }
 * 
 * public void printDocument(CompositeDocumentComponent document) {
 * document.print();
 * }
 * 
 * public void addTableToExamDocument(CompositeDocumentComponent examDocument,
 * String id, String[]... rows) {
 * if (examDocument instanceof ExamDocument) {
 * Table table = new Table(id, rows);
 * for (String[] row : rows) {
 * table.addRow(row);
 * }
 * examDocument.addComponent(table);
 * } else {
 * throw new
 * IllegalArgumentException("This document type does not support tables.");
 * }
 * }
 * 
 * public void addMatrixToExamDocument(CompositeDocumentComponent examDocument,
 * String id, double[]... rows) {
 * if (examDocument instanceof ExamDocument) {
 * Matrix matrix = new Matrix(id, rows);
 * examDocument.addComponent(matrix);
 * } else {
 * throw new
 * IllegalArgumentException("This document type does not support tables.");
 * }
 * }
 * 
 * // used to remove matrix or table from documents
 * public void removeComponentById(CompositeDocumentComponent document, String
 * componentId) {
 * DocumentComponent componentToRemove = document.getComponents().stream()
 * .filter(c -> c.matches(componentId))
 * .findFirst()
 * .orElse(null);
 * 
 * if (componentToRemove != null) {
 * document.removeComponent(componentToRemove);
 * }
 * }
 */

/*
 * public CompositeDocumentComponent createExamDocument(String title, String
 * authorName) {
 * CompositeDocumentComponent examDocument = (CompositeDocumentComponent)
 * factory
 * .createDocument(DocumentType.ExamDocument);
 * examDocument.addComponent(new Title(title));
 * examDocument.addComponent(new Author(authorName));
 * 
 * return examDocument;
 * }
 * 
 * public CompositeDocumentComponent createLetterDocument(String title, String
 * authorName, String paragraphText) {
 * CompositeDocumentComponent letterDocument = (CompositeDocumentComponent)
 * factory
 * .createDocument(DocumentType.LetterDocument);
 * letterDocument.addComponent(new Title(title));
 * letterDocument.addComponent(new Author(authorName));
 * letterDocument.addComponent(new Paragraph(paragraphText));
 * return letterDocument;
 * }
 * 
 * public CompositeDocumentComponent createAcademicCalendarDocument(String
 * title, String authorName,
 * String paragraphText, String id, LocalDateTime date) {
 * CompositeDocumentComponent academicCalendar = (CompositeDocumentComponent)
 * factory
 * .createDocument(DocumentType.AcademicCalendar);
 * academicCalendar.addComponent(new Title(title));
 * academicCalendar.addComponent(new Author(authorName));
 * academicCalendar.addComponent(new Paragraph(paragraphText));
 * academicCalendar.addComponent(new Date(id, date));
 * return academicCalendar;
 * }
 */
