
import Document.DocumentType;
import Document.CompositeDocument.CompositeDocumentComponent;

import Document.DocumentComponents.DocumentComponentType;

import Document.Facade.DocumentFacade;

public class Main {
    public static void main(String[] args) {

        DocumentFacade facade = new DocumentFacade();

        CompositeDocumentComponent examDocument = facade.createDocument(DocumentType.ExamDocument);

        facade.addComponent(examDocument, DocumentComponentType.Title, "Exam Title");

        facade.addComponent(examDocument, DocumentComponentType.Paragraph, "This is an introductory paragraph.");

        facade.editComponent(examDocument, "This is an introductory paragraph.", DocumentComponentType.Paragraph,
                "test2");
        facade.addComponent(examDocument, DocumentComponentType.Paragraph, "This is an introductory paragraph.");
        facade.addComponent(examDocument, DocumentComponentType.Table, "1", "namn", "p-nummer", "kön");
        facade.addRowToTable(examDocument, "1", "Tomas", "12334523", "helikopter");
        facade.addComponent(examDocument, DocumentComponentType.Author, "pehr");
        facade.undoLastAction();
        facade.printDocument(examDocument);
        facade.redoLastAction();
        facade.editComponent(examDocument, "test2", DocumentComponentType.Paragraph,
                "test1");
        facade.printDocument(examDocument);

        String html = facade.buildHtmlDocument(examDocument);
        String markdown = facade.buildMarkdownDocument(examDocument);

        System.out.println(html);
        System.out.println(markdown);

    }
}
