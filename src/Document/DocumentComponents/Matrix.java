package Document.DocumentComponents;

import java.util.Arrays;
import java.util.stream.Collectors;

import Document.CompositeDocument.DocumentComponent;

public class Matrix implements DocumentComponent {
    private double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
    }

    @Override
    public void print() {
        Arrays.stream(data)
                .map(row -> Arrays.stream(row)
                        .mapToObj(Double::toString)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }

    @Override
    public boolean matches(String criterion) {

        return false;
    }
}
