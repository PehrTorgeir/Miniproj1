package Document.DocumentComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Document.CompositeDocument.DocumentComponent;

public class Table implements DocumentComponent {
    private String id;
    private ArrayList<String> headers;
    private ArrayList<String[]> rows;

    public Table(String id, String... headers) {
        this.id = id;
        this.headers = new ArrayList<>(Arrays.asList(headers));
        this.rows = new ArrayList<>();
        System.out.println("hej");
    }

    public void addRow(String... rowData) {
        if (rowData.length != headers.size()) {
            throw new IllegalArgumentException("The number of row data elements must match the number of headers.");
        }
        rows.add(rowData);
    }

    public List<String[]> getTable() {
        return this.rows;
    }

    public String getId() {
        return id;
    }

    @Override
    public void print() {
        System.out.println(String.join("\t", headers));
        rows.stream()
                .map(row -> String.join("\t", row))
                .forEach(System.out::println);
    }

    @Override
    public boolean matches(String criterion) {
        return id.equals(criterion);

    }

    @Override
    public String toHtml() {

        StringBuilder html = new StringBuilder("<table id=" + id + ">\n");
        for (String[] row : rows) {
            html.append("<tr>\n");
            for (String cell : row) {
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

        markdown.append("<!-- Table ID: ").append(id).append(" -->\n");

        markdown.append("| ").append(String.join(" | ", headers)).append(" |\n");

        markdown.append("|").append(" --- |".repeat(headers.size())).append("\n");

        for (String[] row : rows) {
            markdown.append("| ").append(String.join(" | ", row)).append(" |\n");
        }

        return markdown.toString();
    }

    public void removeLastRow() {
        if (rows.size() > 0) {
            System.out.println(rows.size() - 1);
            rows.remove(rows.size() - 1);
        } else {
            throw new IllegalStateException("Cannot remove a row from an empty table.");
        }
    }

}
