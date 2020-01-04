package ru.idmikhailov.plastika.product;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    final
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product get(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void save(ProductDTO product) {
        product.setCount(product.getCount() + 1L);
        Product databaseProduct = new Product(product);
        productRepository.save(databaseProduct);
    }

    @Override
    public void add(ProductDTO product) {
        Product databaseProduct = productRepository.findByName(product.getName());
        if (product.getCount() == 0L) {
            databaseProduct.setCount(databaseProduct.getCount() + 1L);
        } else {
            databaseProduct.setCount(product.getCount());
        }
        productRepository.save(databaseProduct);
    }

    @Override
    public void sell(ProductDTO product) {
        Product databaseProduct = productRepository.findByName(product.getName());
        if (databaseProduct.getCount() == 0L) {
            productRepository.delete(databaseProduct);
        } else {
            databaseProduct.setCount(databaseProduct.getCount() - 1L);
        }
        productRepository.save(databaseProduct);
    }

    @Override
    public void sell(ProductDTO product, long count) {
        if (count == 1L) {
            sell(product);
        }
        Product databaseProduct = productRepository.findByName(product.getName());
        if (databaseProduct.getCount() < product.getCount()) {
            throw new RuntimeException("We don't have so many this product");
        }
        databaseProduct.setCount(databaseProduct.getCount() - count);
        productRepository.save(databaseProduct);
    }
}
