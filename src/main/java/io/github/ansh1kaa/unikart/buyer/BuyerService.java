package io.github.ansh1kaa.unikart.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Buyer-related business logic such as
 * registration, login, update, retrieval, and deletion.
 */
@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    /**
     * Registers a new buyer.
     *
     * @param buyer the buyer to register
     * @return the saved buyer
     */
    public Buyer register(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    /**
     * Authenticates a buyer by email and password.
     *
     * @param email    the buyer's email
     * @param password the buyer's password
     * @return the authenticated buyer, or null if invalid
     */
    public Buyer login(String email, String password) {
        Buyer b = buyerRepository.findByEmail(email);
        if (b != null && b.getPassword().equals(password)) {
            return b;
        }
        return null;
    }

    /**
     * Returns a list of all buyers.
     *
     * @return list of buyers
     */
    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

    /**
     * Retrieves a buyer by their ID.
     *
     * @param id the buyer ID
     * @return the buyer, or null if not found
     */
    public Buyer getById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    /**
     * Updates an existing buyer.
     *
     * @param id    the buyer ID
     * @param newBuyer the updated buyer data
     * @return the updated buyer, or null if not found
     */
    public Buyer update(Long id, Buyer newBuyer) {
        Buyer existing = buyerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(newBuyer.getUsername());
            existing.setEmail(newBuyer.getEmail());
            existing.setPassword(newBuyer.getPassword());
            existing.setPhone(newBuyer.getPhone());
            return buyerRepository.save(existing);
        }
        return null;
    }

    /**
     * Deletes a buyer by their ID.
     *
     * @param id the buyer ID
     */
    public void delete(Long id) {
        buyerRepository.deleteById(id);
    }
}

