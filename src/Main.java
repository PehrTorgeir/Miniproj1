
import Document.CompositeDocument.CompositeDocumentComponent;
import Document.ExamDocumentComponents.Paragraph;
import Document.Facade.DocumentFacade;

public class Main {
    public static void main(String[] args) {
        DocumentFacade facade = new DocumentFacade();

        CompositeDocumentComponent examDocument = facade.createExamDocument(
                "Final Exam",
                "John Doe");

        Paragraph paragraph1 = new Paragraph("Please answer the following questions.");
        facade.addParagraph(examDocument, paragraph1.getText());
        facade.addParagraph(examDocument, "Question 1: Explain the Facade pattern.");
        facade.addParagraph(examDocument, "Question 2: Describe the Factory pattern.");

        facade.removeComponent(examDocument, "Please answer the following questions.");

        facade.updateTitle(examDocument, "Updated Final Exam");
        facade.updateAuthor(examDocument, "Jane Smith");

        facade.printDocument(examDocument);
    }
}
