package ru.idmikhailov.plastika.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Data
@AllArgsConstructor
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private Double price;
    private String picture;
    private Long count;

    public Product() {
    }
    public Product(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.picture = productDTO.getPicture();
        this.count = productDTO.getCount();
    }
}
