package Document.ExamDocumentComponents;

import Document.CompositeDocument.DocumentComponent;

public class Paragraph implements DocumentComponent {
    private String content;

    public Paragraph(String content) {
        this.content = content;
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

  
}
