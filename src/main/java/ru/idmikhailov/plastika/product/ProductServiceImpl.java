package ru.idmikhailov.plastika.product;


import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product get(String name) {
        return productRepository.findByName(name);
    }
}
