package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.List;

import Document.CompositeDocument.DocumentComponent;

public class Table implements DocumentComponent {
    private List<String[]> rows = new ArrayList<>();

    public void addRow(String... rowData) {
        rows.add(rowData);
    }

    @Override
    public void print() {
        rows.stream()
                .map(row -> String.join("\t", row))
                .forEach(System.out::println);
    }

    @Override
    public boolean matches(String criterion) {

        return false;
    }
}
