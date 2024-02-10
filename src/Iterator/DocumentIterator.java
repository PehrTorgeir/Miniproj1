package Iterator;

import Document.CompositeDocument.DocumentComponent;

public interface DocumentIterator {
    boolean hasNext();
    DocumentComponent next();
}
