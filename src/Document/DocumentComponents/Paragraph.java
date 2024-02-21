package Document.DocumentComponents;

import Document.CompositeDocument.DocumentComponent;

public class Paragraph implements DocumentComponent {
    private String content;

    public Paragraph() {

    }

    public Paragraph(String content) {
        this.content = content;
    }

    public void setParagraph(String content) {
        this.content = content;

    }

    public String getParagraph() {
        return this.content;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + content);
    }

    @Override
    public boolean matches(String content) {
        return this.content.equalsIgnoreCase(content);
    }

    public String getText() {
        return this.content;
    }

    @Override
    public String toHtml() {
        return "<p>" + this.content + "<p>";
    }


    @Override
    public String toMarkdown() {
        return this.content;
    }

}
