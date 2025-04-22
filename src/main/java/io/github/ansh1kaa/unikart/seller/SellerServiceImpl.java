package io.github.ansh1kaa.unikart.seller;

import io.github.ansh1kaa.unikart.buyer.BuyerRepository;
import io.github.ansh1kaa.unikart.seller.SellerRepository;
import io.github.ansh1kaa.unikart.product.Product;
import io.github.ansh1kaa.unikart.product.ProductNotFoundException;
import io.github.ansh1kaa.unikart.product.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indicates that this is a service component to be managed by Spring
@Qualifier
public class SellerServiceImpl extends SellerService {

    @Autowired
    private SellerRepository repo; // Injecting the ProductRepository
    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Product addProduct(Product product) {
        return SellerRepository.save(product); // Save product to the database
    }

    @Override
    public Product createProduct(Product product) throws ProductValidationException {
        return null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Fetch all products from the database
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
