package ru.idmikhailov.plastika.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDTO {

    private String name;
    private Double price;
    private String picture;
    private Long count;

    public ProductDTO() {
    }
}
