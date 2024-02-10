package Iterator;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;

public class CompositeDocumentComponentIterator implements DocumentIterator {
    private Queue<DocumentComponent> queue;

    public CompositeDocumentComponentIterator(CompositeDocumentComponent rootComponent) {
        this.queue = new LinkedList<>();

        this.queue.addAll(rootComponent.getComponents());
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public DocumentComponent next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        DocumentComponent component = queue.poll();

        if (component instanceof CompositeDocumentComponent) {
            queue.addAll(((CompositeDocumentComponent) component).getComponents());
        }
        return component;
    }
}
