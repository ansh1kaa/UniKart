package io.github.ansh1kaa.unikart.buyer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class BuyerServiceImpl extends BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Buyer register(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer login(String email, String password) {
        Optional<Buyer> buyer = Optional.ofNullable(buyerRepository.findByEmail(email));
        return buyer.filter(b -> b.getPassword().equals(password)).orElse(null);
    }

    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer getById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Override
    public Buyer update(Long id, Buyer buyer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
