package ru.idmikhailov.plastika.product;

import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {
    Product findByName(String name);
}
