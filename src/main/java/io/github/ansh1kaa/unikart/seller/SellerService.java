package io.github.ansh1kaa.unikart.seller;
import io.github.ansh1kaa.unikart.buyer.SellerRepository;
import io.github.ansh1kaa.unikart.product.Product;
import io.github.ansh1kaa.unikart.product.ProductNotFoundException;
import io.github.ansh1kaa.unikart.product.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller register(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller login(String email, String password) {
        Seller s = sellerRepository.findByEmail(email);
        if (s != null && s.getPassword().equals(password)) return s;
        return null;
    }

    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    public Seller getById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    public Seller update(Long id, Seller newSeller) {
        Seller existing = sellerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(newSeller.getUsername());
            existing.setEmail(newSeller.getEmail());
            existing.setPassword(newSeller.getPassword());
            existing.setPhone(newSeller.getPhone());
            return sellerRepository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        sellerRepository.deleteById(id);
    }

    public Product addProduct() {
        return addProduct(null);

    }

    public abstract Product addProduct(Product product);

    public abstract Product createProduct(Product product) throws ProductValidationException;

    public abstract Product getProductByName(String name) throws ProductNotFoundException;

    public abstract Product updateProductName(Long id, String newName) throws ProductValidationException;

    public abstract boolean deleteProduct(Long id) throws ProductNotFoundException;
}

