package Document.DocumentConverter;

import Document.CompositeDocument.DocumentComponent;

public class HtmlBuilder {
    private StringBuilder htmlBuilder;

    public HtmlBuilder() {
        htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>\n<html>\n<body>\n");
    }

    public HtmlBuilder addComponent(DocumentComponent component) {
        htmlBuilder.append(component.toHtml()).append("\n");
        return this;
    }

    public String build() {
        htmlBuilder.append("</body>\n</html>");
        return htmlBuilder.toString();
    }
}
