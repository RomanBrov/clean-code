package org.robotdreams.patterns.lesson12.theory;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class InterpreterDemo {
    public void start() throws Exception {
        System.out.println("Starting Interpreter Demo");

        ProductFinder productFinder = new ProductFinder(new ProductRepository());

        output("byColor(Yellow)", productFinder.byColor("Yellow"));
        output("byType(Apple)", productFinder.byType("Apple"));
        output("byPrice(3,4)", productFinder.byPrice(3.0, 4.0));

        ProductFinderBySpecs finderBySpecs = new ProductFinderBySpecs(new ProductRepository());

        output("bySpec(Color(Yellow))", finderBySpecs.bySpec(new ColorSpec("Yellow")));
        output("bySpec(Type(Apple))", finderBySpecs.bySpec(new TypeSpec("Apple")));
        output("bySpec(Price(3,4))", finderBySpecs.bySpec(new PriceSpec(3, 4)));
        output("bySpec(Color(Yellow) && Type(Apple))",
                finderBySpecs.bySpec(
                        new AndSpec(new ColorSpec("Yellow"),
                                new TypeSpec("Apple"))));
        AndSpec filter = new AndSpec(
                new PriceSpec(1, 4),
                new OrSpec(
                        new ColorSpec("Yellow"),
                        new TypeSpec("Apple")));
        output(filter, finderBySpecs.bySpec(filter));

        System.out.println();
        System.out.printf("exporting to query format: %s%n", filter.getQueryPart());
        System.out.println();

        System.out.println("Iterator With Interpreter:");

        var finderWithIterator = new ProductFinderWithIterator(new ProductRepository());
        output(filter, finderWithIterator.bySpec(filter));

        // product_color = 'Yellow' and type = 'Apple' and (price between 3 and 4)

        // (3+4)*a

        // (a & b) || (c & d) =>
        // (a || b) && (c || d) =>

        System.out.println();
    }

    private void output(String filterDescription, List<Product> items) {
        System.out.printf("Found %d items for filter '%s' : %s %n",
                items.size(),
                filterDescription,
                items.stream().map(p -> p.getColor() + " " + p.getType()).collect(Collectors.joining(", "))
        );
    }

    private void output(Spec filter, List<Product> items) {
        String filterDescription = filter.getQueryPart();
        System.out.printf("Found %d items for filter '%s' : %s %n",
                items.size(),
                filterDescription,
                items.stream().map(p -> p.getColor() + " " + p.getType()).collect(Collectors.joining(", "))
        );
    }

    private void output(Spec filter, Iterator<Product> items) {
        StringBuilder stringBuilder = new StringBuilder();
        String filterDescription = filter.getQueryPart();
        int count = 0;
        while (items.hasNext()) {
            Product product = items.next();
            stringBuilder.append(product.getColor()).append(" ").append(product.getType());
            if (items.hasNext()) {
                stringBuilder.append(", ");
            }
            count++;
        }
        System.out.printf("Found %d items for filter '%s': %s%n", count, filterDescription, stringBuilder.toString());
    }
}

class ProductFinder {
    private ProductRepository repository;

    ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> byColor(String productColorToFind) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getColor() == productColorToFind) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public List<Product> byType(String productTypeToFind) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getType() == productTypeToFind) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public List<Product> byPrice(double from, double to) throws Exception {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (product.getPrice() >= from && product.getPrice() <= to) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

    public List<Product> byPrice(double maxPrice) throws Exception {
        throw new Exception("not implemented");
    }

    public List<Product> byPriceAndColor(String color, double from, double to) throws Exception {
        throw new Exception("not implemented");
    }

    public List<Product> byPriceAndType(String type, double from, double to) throws Exception {
        throw new Exception("not implemented");
    }

}

class ProductRepository {

    private final List products = Arrays.asList(
            new Product(1, "Red", "Apple", 2.5),
            new Product(2, "Yellow", "Apple", 2.8),
            new Product(3, "Green", "Apple", 2.2),
            new Product(4, "Green", "Lime", 3),
            new Product(5, "Yellow", "Lemon", 2),
            new Product(6, "Yellow", "Banana", 1.5),
            new Product(7, "Blue", "Plum", 2.7),
            new Product(8, "Blue", "Grapes", 3.5)
    );

    public Iterator<Product> iterator() {
        return products.iterator();
    }

}

class Product {
    private final int id;
    private final String color;
    private final String type;
    private final double price;

    public Product(int id, String color, String type, double price) {
        this.id = id;
        this.color = color;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}