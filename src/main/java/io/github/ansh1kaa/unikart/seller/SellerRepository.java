package io.github.ansh1kaa.unikart.seller;

import io.github.ansh1kaa.unikart.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUsername(String username);

    Optional<Seller> findByEmail(String email);

    boolean existsByEmail(String email);
}


