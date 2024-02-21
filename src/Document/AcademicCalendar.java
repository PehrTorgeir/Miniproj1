package Document;



import Document.CompositeDocument.CompositeDocumentComponent;
import Document.CompositeDocument.DocumentComponent;
import Document.DocumentConverter.MarkdownBuilder;


public class AcademicCalendar extends CompositeDocumentComponent {

    @Override
    public boolean matches(String content) {
        // only avalible for leaf classes
        return false;
    }

    @Override
    public String toHtml() {
        
        StringBuilder html = new StringBuilder("<div class='Academic-Calendar'>\n");

      
        for (DocumentComponent component : getComponents()) {
            html.append(component.toHtml()).append("\n");
        }

        html.append("</div>");
        return html.toString();
    }



    @Override
    public String toMarkdown() {
        MarkdownBuilder builder = new MarkdownBuilder().startSection("Academic Calendar");

        for (DocumentComponent component : getComponents()) {
            builder.addComponent(component);
        }

        return builder.endSection().build();
    }

   

}
