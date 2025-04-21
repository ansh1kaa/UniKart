package io.github.ansh1kaa.unikart.buyer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Buyer findByEmail(String email);



}

