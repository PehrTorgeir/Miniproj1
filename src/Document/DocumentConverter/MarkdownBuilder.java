package Document.DocumentConverter;

import Document.CompositeDocument.DocumentComponent;

public class MarkdownBuilder {
    private StringBuilder markdownBuilder;

    public MarkdownBuilder() {
        markdownBuilder = new StringBuilder();
    }


    public MarkdownBuilder startSection(String title) {
        markdownBuilder.append("# ").append(title).append("\n\n");
        return this;
    }

    public MarkdownBuilder endSection() {
        markdownBuilder.append("\n");
        return this;
    }

    public MarkdownBuilder addComponent(DocumentComponent component) {
        markdownBuilder.append(component.toMarkdown()).append("\n\n");
        return this;
    }

    public String build() {
        return markdownBuilder.toString().trim();
    }
}
