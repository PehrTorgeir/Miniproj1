package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import Document.CompositeDocument.DocumentComponent;

public class Matrix implements DocumentComponent {
    private String id;
    private ArrayList<double[]> rows;

    public Matrix(String id) {
        this.id = id;
        this.rows = new ArrayList<>();
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

    @Override
    public String toMarkdown() {
        StringBuilder markdown = new StringBuilder();
        for (double[] row : rows) {
            markdown.append("| ");
            for (double cell : row) {
                markdown.append(cell).append(" |");
            }
            markdown.append("\n");
        }
        return markdown.toString();
    }
}
