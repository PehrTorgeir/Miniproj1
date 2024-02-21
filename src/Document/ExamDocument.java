package Document;

import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.DocumentConverter.HtmlBuilder;
import Document.DocumentConverter.MarkdownBuilder;

public class ExamDocument extends CompositeDocumentComponent {

    @Override
    public boolean matches(String content) {
        // only avalible for leaf classes
        return false;
    }

    @Override
    public String toHtml() {
        HtmlBuilder builder = new HtmlBuilder().startDiv("exam-document");

        for (DocumentComponent component : getComponents()) {
            builder.addComponent(component);
        }

        return builder.endDiv().build();
    }



    @Override
    public String toMarkdown() {
        MarkdownBuilder builder = new MarkdownBuilder().startSection("Exam Document");

        for (DocumentComponent component : getComponents()) {
            builder.addComponent(component);
        }

        return builder.endSection().build();
    }
}
