package Command;

import Document.DocumentComponents.Table;

public class AddRowCommand implements Command {
    private Table table;
    private String[] rowData;

    public AddRowCommand(Table table, String[] rowData) {
        this.table = table;
        this.rowData = rowData;
    }

    @Override
    public void execute() {
       
        table.addRow(rowData);
    }

    @Override
    public void undo() {
        table.removeLastRow();
    }

    @Override
    public void redo() {
        execute();
    }
}
