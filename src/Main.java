
import Document.CompositeDocument.CompositeDocumentComponent;
import Document.DocumentComponents.Paragraph;
import Document.Facade.DocumentFacade;

public class Main {
    public static void main(String[] args) {
        DocumentFacade facade = new DocumentFacade();

        CompositeDocumentComponent examDocument = facade.createExamDocument(
                "Final Exam",
                "John Doe");

        Paragraph paragraph1 = new Paragraph("Please answer the following questions.");
        double[][] matrixData = { { 1, 2 }, { 1, 2 } };
        facade.addParagraph(examDocument, paragraph1.getText());
        facade.addParagraph(examDocument, "Question 1: Explain the Facade pattern.");
        facade.addParagraph(examDocument, "Question 2: Describe the Factory pattern.");
        facade.addTableToExamDocument(examDocument, new String[] { "Header1", "Header2" },
                new String[] { "Row1Col1", "Row1Col2" }, new String[] { "Row2Col1", "Row2Col2" });
        facade.removeComponent(examDocument, "Please answer the following questions.");

        facade.updateTitle(examDocument, "Updated Final Exam");
        facade.updateAuthor(examDocument, "Jane Smith");
        facade.addMatrixToExamDocument(examDocument, matrixData);

        facade.printDocument(examDocument);
    }
}
