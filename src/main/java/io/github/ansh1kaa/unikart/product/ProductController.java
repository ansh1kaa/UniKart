package io.github.ansh1kaa.unikart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API Controller for Product operations.
 */
@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product create(@RequestBody Product product) throws ProductValidationException {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() throws ProductNotFoundException {
        return service.getAllProducts();
    }

    @GetMapping("/{name}")
    public Product getByName(@PathVariable String name) throws ProductNotFoundException {
        return service.getProductByName(name);
    }

    @PutMapping("/{id}")
    public Product updateName(@PathVariable Long id, @RequestParam String name)
            throws ProductValidationException {
        return service.updateProductName(id, name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ProductNotFoundException {
        service.deleteProduct(id);
        return "Product deleted successfully.";
    }
}