/* package Iterator;


import java.util.List;

import Document.ExamDocumentComponents.BredText;

// Specific iterator for Section objects within ExamDocument
public class ExamDocumentIterator implements Iterator<BredText> {
    private List<BredText> sections;
    private int position = 0;

    public ExamDocumentIterator(List<BredText> sections) {
        this.sections = sections;
    }

    @Override
    public boolean hasNext() {
        return position < sections.size();
    }

    @Override
    public BredText next() {
        return hasNext() ? sections.get(position++) : null;
    }
}
 */