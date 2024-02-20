package Document.DocumentComponents;

import Document.CompositeDocument.DocumentComponent;

public class Title implements DocumentComponent {
    private String title;

    public Title() {

    }

    public Title(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public void print() {
        System.out.println("Title: " + title);
    }

    @Override
    public boolean matches(String content) {
        return title.equalsIgnoreCase(content);

    }

    @Override
    public String toHtml() {
        return "<h1>" + this.title + "<h1>";
    }
}
