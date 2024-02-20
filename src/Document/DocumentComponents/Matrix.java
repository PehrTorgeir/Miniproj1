package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Document.CompositeDocument.DocumentComponent;

public class Matrix implements DocumentComponent {
    private String id;
    private List<double[]> rows = new ArrayList<>();

    public Matrix() {

    }

    public Matrix(String id, double[]... initialRows) {
        this.id = id;
        Arrays.stream(initialRows).forEach(rows::add);
    }

    public void addRow(double... rowData) {
        rows.add(rowData);
    }

    public String getId() {
        return id;
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

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder("<table id=" + id + ">\n");
        for (double[] row : rows) {
            html.append("<tr>\n");
            for (double cell : row) {
                html.append("<td>").append(cell).append("</td>\n");
            }
            html.append("</tr>\n");
        }
        html.append("</table>");
        return html.toString();
    }
}
