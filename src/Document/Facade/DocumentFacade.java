package Document.Facade;

import Document.DocumentType;
import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.ExamDocumentComponents.Author;
import Document.ExamDocumentComponents.Paragraph;
import Document.ExamDocumentComponents.Title;
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

}
