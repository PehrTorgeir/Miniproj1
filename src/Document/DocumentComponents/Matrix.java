package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Document.CompositeDocument.DocumentComponent;

public class Matrix implements DocumentComponent {
    private String id;
    private List<double[]> rows = new ArrayList<>();

    public Matrix(String id, double[]... initialRows) {
        this.id = id;
        Arrays.stream(initialRows).forEach(rows::add);
    }

    public void addRow(double... rowData) {
        rows.add(rowData);
    }

    @Override
    public void print() {
        rows.stream()
                .map(row -> Arrays.stream(row)
                        .mapToObj(Double::toString)
                        .collect(Collectors.joining("\t")))
                .forEach(System.out::println);
    }

    @Override
    public boolean matches(String criterion) {
        return id.equals(criterion);

    }
}
