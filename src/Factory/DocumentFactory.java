package Factory;

import Document.DocumentType;
import Document.CompositeDocument.CompositeDocumentComponent;

public interface DocumentFactory {
    CompositeDocumentComponent createDocument(DocumentType Type);
}
