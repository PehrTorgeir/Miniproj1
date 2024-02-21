package Document.DocumentConverter;

import Document.CompositeDocument.DocumentComponent;

public class HtmlBuilder {
    private StringBuilder htmlBuilder;

    public HtmlBuilder() {
        htmlBuilder = new StringBuilder();
    }

    public HtmlBuilder startDiv(String cssClass) {
        htmlBuilder.append("<div class='").append(cssClass).append("'>\n");
        return this;
    }

    public HtmlBuilder endDiv() {
        htmlBuilder.append("</div>\n");
        return this;
    }

    public HtmlBuilder addComponent(DocumentComponent component) {
        htmlBuilder.append(component.toHtml()).append("\n");
        return this;
    }

    public String build() {
        htmlBuilder.append("</body>\n</html>");
        return htmlBuilder.toString();
    }
    /*
     * private StringBuilder htmlBuilder;
     * 
     * public HtmlBuilder() {
     * htmlBuilder = new StringBuilder();
     * htmlBuilder.append("<!DOCTYPE html>\n<html>\n<body>\n");
     * }
     * 
     * public HtmlBuilder addComponent(DocumentComponent component) {
     * htmlBuilder.append(component.toHtml()).append("\n");
     * return this;
     * }
     * 
     * public String build() {
     * htmlBuilder.append("</body>\n</html>");
     * return htmlBuilder.toString();
     * }
     */
}
