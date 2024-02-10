package Document.Facade;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Document.DocumentType;
import Document.ExamDocument;
import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.DocumentComponents.Author;
import Document.DocumentComponents.Date;
import Document.DocumentComponents.Matrix;
import Document.DocumentComponents.Paragraph;
import Document.DocumentComponents.Table;
import Document.DocumentComponents.Title;
import Factory.ConcreteDocumentFactory;

public class DocumentFacade {
    private final ConcreteDocumentFactory factory;

    public DocumentFacade() {
        this.factory = new ConcreteDocumentFactory();
    }

    public CompositeDocumentComponent createExamDocument(String title, String authorName) {
        CompositeDocumentComponent examDocument = (CompositeDocumentComponent) factory
                .createDocument(DocumentType.ExamDocument);
        examDocument.addComponent(new Title(title));
        examDocument.addComponent(new Author(authorName));

        return examDocument;
    }

    public CompositeDocumentComponent createLetterDocument(String title, String authorName, String paragraphText) {
        CompositeDocumentComponent letterDocument = (CompositeDocumentComponent) factory
                .createDocument(DocumentType.LetterDocument);
        letterDocument.addComponent(new Title(title));
        letterDocument.addComponent(new Author(authorName));
        letterDocument.addComponent(new Paragraph(paragraphText));
        return letterDocument;
    }

    public CompositeDocumentComponent createAcademicCalendarDocument(String title, String authorName,
            String paragraphText, String id, LocalDateTime date) {
        CompositeDocumentComponent academicCalendar = (CompositeDocumentComponent) factory
                .createDocument(DocumentType.AcademicCalendar);
        academicCalendar.addComponent(new Title(title));
        academicCalendar.addComponent(new Author(authorName));
        academicCalendar.addComponent(new Paragraph(paragraphText));
        academicCalendar.addComponent(new Date(id, date));
        return academicCalendar;
    }

    public void addParagraph(CompositeDocumentComponent document, String paragraphText) {
        document.addComponent(new Paragraph(paragraphText));
    }

    public void updateTitle(CompositeDocumentComponent document, String newTitle) {

        document.getComponents().stream()
                .filter(c -> c instanceof Title)
                .findFirst()
                .ifPresent(document::removeComponent);

        document.addComponent(new Title(newTitle));
    }

    public void updateAuthor(CompositeDocumentComponent document, String newAuthor) {

        document.getComponents().stream()
                .filter(c -> c instanceof Author)
                .findFirst()
                .ifPresent(document::removeComponent);

        document.addComponent(new Author(newAuthor));
    }

    // used for removing title,paragraph or author only.
    public void removeComponent(CompositeDocumentComponent document, String content) {
        DocumentComponent componentToRemove = document.getComponents().stream()
                .filter(c -> c.matches(content))
                .findFirst()
                .orElse(null);

        if (componentToRemove != null) {
            document.removeComponent(componentToRemove);
        }
    }

    public void printDocument(CompositeDocumentComponent document) {
        document.print();
    }

    public void addTableToExamDocument(CompositeDocumentComponent examDocument, String id, String[]... rows) {
        if (examDocument instanceof ExamDocument) {
            Table table = new Table(id, rows);
            for (String[] row : rows) {
                table.addRow(row);
            }
            examDocument.addComponent(table);
        } else {
            throw new IllegalArgumentException("This document type does not support tables.");
        }
    }

    public void addMatrixToExamDocument(CompositeDocumentComponent examDocument, String id, double[]... rows) {
        if (examDocument instanceof ExamDocument) {
            Matrix matrix = new Matrix(id, rows);
            examDocument.addComponent(matrix);
        } else {
            throw new IllegalArgumentException("This document type does not support tables.");
        }
    }

    // used to remove matrix or table from documents
    public void removeComponentById(CompositeDocumentComponent document, String componentId) {
        DocumentComponent componentToRemove = document.getComponents().stream()
                .filter(c -> c.matches(componentId))
                .findFirst()
                .orElse(null);

        if (componentToRemove != null) {
            document.removeComponent(componentToRemove);
        }
    }

    

}
