package Factory;

import Document.AcademicCalendar;

import Document.DocumentType;
import Document.ExamDocument;
import Document.LetterDocument;
import Document.CompositeDocument.CompositeDocumentComponent;

public class ConcreteDocumentFactory implements DocumentFactory {
    @Override
    public CompositeDocumentComponent createDocument(DocumentType type) {
        switch (type) {
            case ExamDocument:
                return  new ExamDocument();
            case LetterDocument:
                return  new LetterDocument();
            case AcademicCalendar:
                return  new AcademicCalendar();
            default:
                throw new IllegalArgumentException("Invalid document type: " + type);
        }
    }
}


