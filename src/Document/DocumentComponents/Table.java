package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Document.CompositeDocument.DocumentComponent;

public class Table implements DocumentComponent {
    String id;
    private List<String[]> rows = new ArrayList<>();

    public Table(String id, String[]... initialRows) {
        this.id = id;
        Arrays.stream(initialRows).forEach(rows::add);
    }

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
        return id.equals(criterion);

    }
}
