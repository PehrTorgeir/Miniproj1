
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
                "test1");
        facade.editComponent(examDocument, "test1", DocumentComponentType.Paragraph, "test2");
        facade.addComponent(examDocument, DocumentComponentType.Paragraph, "This is an introductory paragraph.");
        facade.addComponent(examDocument, DocumentComponentType.Table, "1","2","3","4");
        facade.printDocument(examDocument);

        String htmlDocument = facade.buildHtmlDocument(examDocument);

        // Output the HTML
        System.out.println(htmlDocument);

        /*
         * 
         * 
         * 
         * facade.addComponent(examDocument, DocumentComponentType.Date, "2023-05-15");
         * 
         * 
         * System.out.println("Document after adding components:");
         * examDocument.print();
         * 
         * 
         * facade.removeComponent(examDocument, "This is an introductory paragraph.");
         * 
         * 
         * String oldTitle = "Exam Title";
         * String newTitle = "Updated Exam Title";
         * facade.editComponent(examDocument, oldTitle, DocumentComponentType.Title,
         * newTitle);
         * 
         * 
         * System.out.
         * println("\nDocument after editing the title and removing the paragraph:");
         * examDocument.print();
         * 
         * 
         * facade.undoLastAction();
         * facade.undoLastAction();
         * 
         * 
         * System.out.println("\nDocument after undo operations:");
         * examDocument.print();
         * 
         * 
         * facade.redoLastAction();
         * facade.redoLastAction();
         * 
         * System.out.println("\nDocument after redo operations:");
         * examDocument.print();
         */

    }
}
