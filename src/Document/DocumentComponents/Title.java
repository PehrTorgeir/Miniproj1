package Document.DocumentComponents;

import Document.CompositeDocument.DocumentComponent;

public class Title implements DocumentComponent {
    private String title;

    public Title(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Title: " + title);
    }

    @Override
    public boolean matches(String content) {
        return title.equalsIgnoreCase(content);

    }
}
