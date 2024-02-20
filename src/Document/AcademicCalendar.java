package Document;



import Document.CompositeDocument.CompositeDocumentComponent;


public class AcademicCalendar extends CompositeDocumentComponent {

    @Override
    public boolean matches(String content) {
        // only avalible for leaf classes
        return false;
    }

    @Override
    public String toHtml() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toHTML'");
    }

   

}
