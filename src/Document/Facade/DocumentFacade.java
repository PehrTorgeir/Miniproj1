package Document.Facade;

import java.time.LocalDate;

import Document.AcademicCalendar;
import Document.DocumentType;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.DocumentComponents.Author;
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
        CompositeDocumentComponent examDocument = (CompositeDocumentComponent) factory
                .createDocument(DocumentType.ExamDocument);
        examDocument.addComponent(new Title(title));
        examDocument.addComponent(new Author(authorName));
        examDocument.addComponent(new Paragraph(paragraphText));
        return examDocument;
    }

    public CompositeDocumentComponent createAcademicCalendarDocument(String title, String authorName,
            String paragraphText) {
        CompositeDocumentComponent examDocument = (CompositeDocumentComponent) factory
                .createDocument(DocumentType.ExamDocument);
        examDocument.addComponent(new Title(title));
        examDocument.addComponent(new Author(authorName));
        examDocument.addComponent(new Paragraph(paragraphText));
        return examDocument;
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
        Table table = new Table(id, rows);
        for (String[] row : rows) {
            table.addRow(row);
        }
        examDocument.addComponent(table);
    }

    public void addMatrixToExamDocument(CompositeDocumentComponent examDocument, String id, double[]... rows) {
        Matrix matrix = new Matrix(id, rows);
        examDocument.addComponent(matrix);
    }

    public void addDateToAcademicCalendar(CompositeDocumentComponent academicCalendar, String id, LocalDate date,
            String description) {
        if (academicCalendar instanceof AcademicCalendar) {
            ((AcademicCalendar) academicCalendar).addDate(id, date, description);
        }
    }

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
