
import java.time.LocalDate;
import java.time.LocalDateTime;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.DocumentComponents.Paragraph;
import Document.Facade.DocumentFacade;
import Iterator.DocumentIterator;

public class Main {
    public static void main(String[] args) {
        DocumentFacade facade = new DocumentFacade();

        /*
         * CompositeDocumentComponent examDocument = facade.createExamDocument(
         * "Final Exam",
         * "John Doe");
         * 
         * Paragraph paragraph1 = new
         * Paragraph("Please answer the following questions.");
         * 
         * facade.addParagraph(examDocument, paragraph1.getText());
         * facade.addParagraph(examDocument, "Question 1: Explain the Facade pattern.");
         * facade.addParagraph(examDocument,
         * "Question 2: Describe the Factory pattern.");
         * 
         * facade.addTableToExamDocument(examDocument, "1", new String[] { "Header1",
         * "Header2" },
         * new String[] { "Row1Col1", "Row1Col2" }, new String[] { "Row2Col1",
         * "Row2Col2" });
         * facade.addMatrixToExamDocument(examDocument, "2", new double[] { 1.0, 2.0 },
         * new double[] { 3.0, 4.0 });
         * 
         * facade.removeComponent(examDocument,
         * "Please answer the following questions.");
         * 
         * facade.updateTitle(examDocument, "Updated Final Exam");
         * facade.updateAuthor(examDocument, "Jane Smith");
         * 
         * facade.removeComponentById(examDocument, "2");
         * 
         * DocumentIterator iterator = examDocument.iterator();
         * while (iterator.hasNext()) {
         * DocumentComponent component = iterator.next();
         * component.print();
         * 
         * }
         */

        CompositeDocumentComponent academicDocument = facade.createAcademicCalendarDocument("möte2", "pehr",
                "möte med chefen", "1", LocalDateTime.now());
        DocumentIterator it = academicDocument.iterator();
        while (it.hasNext()) {
            DocumentComponent component = it.next();
            component.print();
        }
        academicDocument.updateDate("1", LocalDateTime.now().plusDays(10));
        DocumentIterator it2 = academicDocument.iterator();
        while (it2.hasNext()) {
            DocumentComponent component2 = it2.next();
            component2.print();
        }
    }
}
