package ru.idmikhailov.plastika.product;

public interface ProductService {

    Product get(String name);
    void save(ProductDTO product);

    void add(ProductDTO product);

    void sell(ProductDTO product);

    void sell(ProductDTO product, long count);
}
