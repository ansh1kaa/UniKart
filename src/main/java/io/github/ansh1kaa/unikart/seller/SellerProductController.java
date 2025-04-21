package io.github.ansh1kaa.unikart.seller;

import io.github.ansh1kaa.unikart.product.Product;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SellerProductController {
    @Column(nullable = false)
    private Long sellerId;  // Reference to Seller
    public interface ProductRepository extends JpaRepository<Product, Long> {
        List<Product> findBySellerId(Long sellerId);
    }

    @RestController
    @RequestMapping("/seller/products")
    public class SellerController {

        @Autowired
        private ProductRepository productRepo;

        // ✅ Create Product
        @PostMapping("/add")
        public Product addProduct(@RequestBody Product product) {
            return productRepo.save(product);
        }

        // ✅ Get all Products for this Seller
        @GetMapping("/all/{sellerId}")
        public List<Product> getProducts(@PathVariable Long sellerId) {
            return productRepo.findBySellerId(sellerId);
        }

        // ✅ Update Product
        @PutMapping("/update/{productId}")
        public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
                                                     @RequestBody Product updatedProduct) {
            return productRepo.findById(productId).map(product -> {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setDescription(updatedProduct.getDescription());
                product.setQuantity(updatedProduct.getQuantity());
                return ResponseEntity.ok(productRepo.save(product));
            }).orElse(ResponseEntity.notFound().build());
        }

        // ✅ Delete Product
        @DeleteMapping("/delete/{productId}")
        public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
            if (productRepo.existsById(productId)) {
                productRepo.deleteById(productId);
                return ResponseEntity.ok("Product deleted successfully.");
            } else {
                return ResponseEntity.status(404).body("Product not found.");
            }
        }
    }



}
