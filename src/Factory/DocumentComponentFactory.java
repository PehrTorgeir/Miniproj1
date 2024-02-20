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
                return new Table(args[0], convertToString2DArray(Arrays.copyOfRange(args, 1, args.length)));
            case Matrix:
                
                return new Matrix(args[0], convertToDouble2DArray(Arrays.copyOfRange(args, 1, args.length)));
            case Date:
                return new Date(parseDate(args[0]));
            case Author:
                return new Author(args[0]);
            default:
                throw new IllegalArgumentException("Invalid documentCompoent type: " + type);
        }

    }

    private double[][] convertToDouble2DArray(String[] stringData) {
        return Arrays.stream(stringData)
                .map(row -> Arrays.stream(row.split(","))
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .toArray(double[][]::new);
    }

    private String[][] convertToString2DArray(String[] stringData) {
        return Arrays.stream(stringData)
                .map(row -> row.split(","))
                .toArray(String[][]::new);
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