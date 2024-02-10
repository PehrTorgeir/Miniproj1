package Document.CompositeDocument;

public interface DocumentComponent {
    void print();
    boolean matches(String content);
}