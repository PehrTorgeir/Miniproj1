package Document.DocumentComponents;

import Document.CompositeDocument.DocumentComponent;

public class Author implements DocumentComponent {
    private String author;

    public Author() {

    }

    public Author(String author) {
        this.author = author;

    }

    @Override
    public void print() {
        System.out.println("Author: " + author);
    }

    @Override
    public boolean matches(String content) {
        return author.equalsIgnoreCase(content);
    }

    @Override
    public String toHtml() {
        return "<div id=author>" + this.author + "</div>";
    }


    @Override
    public String toMarkdown() {
        return "**Author:** " + author;
    }
}
