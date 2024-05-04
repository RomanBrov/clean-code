package org.robotdreams.patterns.lesson12.theory;

import java.util.*;

abstract class Spec {
    public abstract boolean isSatisfied(Product product);

    public abstract String getQueryPart();
}

class ColorSpec extends Spec {

    private final String color;

    public ColorSpec(String color) {

        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return Objects.equals(product.getColor(), color);
    }

    @Override
    public String getQueryPart() {
        return "color = " + this.color;
    }
}

class TypeSpec extends Spec {

    private final String type;

    public TypeSpec(String type) {

        this.type = type;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return Objects.equals(product.getType(), type);
    }

    @Override
    public String getQueryPart() {
        return "type = " + this.type;
    }
}

class PriceSpec extends Spec {

    private final double from;
    private final double to;

    public PriceSpec(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return product.getPrice() >= from && product.getPrice() <= to;
    }

    @Override
    public String getQueryPart() {
        return "price in range " + from + "," + to;
    }
}

class AndSpec extends Spec {
    private final Spec augend;
    private final Spec addend;

    public AndSpec(Spec augend, Spec addend) {

        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return augend.isSatisfied(product) && addend.isSatisfied(product);
    }

    @Override
    public String getQueryPart() {
        return augend.getQueryPart() + " and " + addend.getQueryPart();
    }
}

class OrSpec extends Spec {
    private final Spec augend;
    private final Spec addend;

    public OrSpec(Spec augend, Spec addend) {

        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return augend.isSatisfied(product) || addend.isSatisfied(product);
    }

    @Override
    public String getQueryPart() {
        return "(" + augend.getQueryPart() + " or " + addend.getQueryPart() + ")";
    }
}

class ProductFinderBySpecs {
    private final ProductRepository repository;

    ProductFinderBySpecs(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> bySpec(Spec spec) {
        List<Product> foundProducts = new ArrayList<>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (spec.isSatisfied(product)) {
                foundProducts.add(product);
            }
        }

        return foundProducts;
    }

}

class ProductFinderWithIterator {
    private final ProductRepository repository;

    ProductFinderWithIterator(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterator<Product> bySpec(Spec spec) {
        return new Iterator<Product>() {
            private Iterator<Product> products = repository.iterator();
            private Product nextProduct = findNextProduct();

            @Override
            public boolean hasNext() {
                return nextProduct != null;
            }

            @Override
            public Product next() {
                if (nextProduct == null) {
                    throw new NoSuchElementException();
                }

                Product currentProduct = nextProduct;
                nextProduct = findNextProduct();
                return currentProduct;
            }

            private Product findNextProduct() {
                while (products.hasNext()) {
                    Product product = products.next();
                    if (spec.isSatisfied(product)) {
                        return product;
                    }
                }
                return null;
            }
        };
    }
}