package ru.idmikhailov.plastika.product;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product get(String name);
}
