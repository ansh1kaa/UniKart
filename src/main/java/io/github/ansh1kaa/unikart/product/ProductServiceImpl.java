package io.github.ansh1kaa.unikart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indicates that this is a service component to be managed by Spring
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo; // Injecting the ProductRepository

    @Override
    public Product addProduct(Product product) {
        return repo.save(product); // Save product to the database
    }

    @Override
    public Product createProduct(Product product) throws ProductValidationException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll(); // Fetch all products from the database
    }

    @Override
    public Product getProductByName(String name) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProductName(Long id, String newName) throws ProductValidationException {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        return false;
    }
}
