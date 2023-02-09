package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/products")
    public ResponseEntity<Set<Product>> getProducts() {
        Set<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id) {
        Product product = productService.update(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        Product product = productService.delete(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
