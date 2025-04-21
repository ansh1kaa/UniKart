package io.github.ansh1kaa.unikart.buyer;

import io.github.ansh1kaa.unikart.product.Product;
import io.github.ansh1kaa.unikart.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    static Product save(Product product) {
        return SellerRepository.save(product);
    }

    Seller findByEmail(String email);
}

