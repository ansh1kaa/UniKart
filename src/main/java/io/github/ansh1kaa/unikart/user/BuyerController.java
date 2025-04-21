package io.github.ansh1kaa.unikart.user;

import io.github.ansh1kaa.unikart.buyer.Buyer;
import io.github.ansh1kaa.unikart.buyer.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerService service;

    @PostMapping("/register")
    public Buyer register(@RequestBody Buyer buyer) {
        return service.register(buyer);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Buyer b) {
        Buyer found = service.login(b.getEmail(), b.getPassword());
        if (found != null)
            return ResponseEntity.ok("Login successful");
        else
            return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @GetMapping
    public List<Buyer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Buyer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public Buyer update(@PathVariable Long id, @RequestBody Buyer buyer) {
        return service.update(id, buyer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Buyer deleted");
    }
}


