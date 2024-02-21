package Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import Document.CompositeDocument.DocumentComponent;
import Document.DocumentComponents.*;

public class DocumentComponentFactory {

    public DocumentComponent createComponent(DocumentComponentType type, String... args) {
        switch (type) {
            case Title:
                return new Title(args[0]);
            case Paragraph:
                return new Paragraph(args[0]);
            case Table:

                if (args.length < 2) {
                    throw new IllegalArgumentException("Table must have at least an ID and one header.");
                }
                
                return new Table(args[0], Arrays.copyOfRange(args, 1, args.length));
            case Matrix:
                if (args.length < 1) {
                    throw new IllegalArgumentException("Matrix must have at least an ID.");
                }
                
                return new Matrix(args[0]);
            case Date:
                return new Date(parseDate(args[0]));
            case Author:
                return new Author(args[0]);
            default:
                throw new IllegalArgumentException("Invalid documentCompoent type: " + type);
        }

    }

    private LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateString);
        }
    }
}