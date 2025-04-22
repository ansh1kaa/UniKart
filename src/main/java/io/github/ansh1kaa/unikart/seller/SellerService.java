package io.github.ansh1kaa.unikart.seller;

import io.github.ansh1kaa.unikart.seller.SellerRepository;
import io.github.ansh1kaa.unikart.product.Product;
import io.github.ansh1kaa.unikart.product.ProductNotFoundException;
import io.github.ansh1kaa.unikart.product.ProductRepository;
import io.github.ansh1kaa.unikart.product.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    public ProductRepository productRepository; // ✅ Add this

    // ... Seller methods ...

    // Create
    public Product addProduct(Product product) {
        return productRepository.save(product); // ✅ Use injected productRepository
    }

    public abstract Product createProduct(Product product) throws ProductValidationException;

    // Read
    public Product getProductByName(String name) throws ProductNotFoundException {
        return productRepository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + name));
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update
    public Product updateProductName(Long id, String newName) throws ProductValidationException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductValidationException("Invalid product ID"));

        product.setName(newName);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) throws ProductValidationException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductValidationException("Invalid product ID"));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }

    // Delete
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
        return true;
    }

    // Utility
    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }

    public SellerRepository getSellerRepository() {
        return sellerRepository;
    }

    public void setSellerRepository(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
}
