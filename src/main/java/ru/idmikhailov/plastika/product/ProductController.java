package ru.idmikhailov.plastika.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity create(@RequestBody ProductDTO product) {
        productService.save(product);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity add(@RequestBody ProductDTO product) {
        productService.add(product);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/addAll", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity addAll(@RequestBody ProductDTO product) {
        productService.add(product);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/sell", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity sell(@RequestBody ProductDTO product) {
        productService.sell(product);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/sellFew", method = RequestMethod.POST, consumes = "application/JSON")
    public ResponseEntity sellFew(@RequestBody ProductDTO product, @PathVariable Long count) {
        productService.sell(product);

        return new ResponseEntity(HttpStatus.OK);
    }
}
