package Document;

import Document.CompositeDocument.CompositeDocumentComponent;

public class ExamDocument extends CompositeDocumentComponent {

    @Override
    public boolean matches(String content) {
        // only avalible for leaf classes
        return false;
    }
    // TODO 
    /*
     * public void addTable(Table table) {
     * super.addComponent(table);
     * }
     * 
     * public void addMatrix(Matrix matrix) {
     * super.addComponent(matrix);
     * }
     */

}
