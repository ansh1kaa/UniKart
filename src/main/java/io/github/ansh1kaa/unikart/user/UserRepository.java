package io.github.ansh1kaa.unikart.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByUsername(String username);
boolean existsByUsername(String username);
Optional<User> findByEmail(String email);
boolean existsByEmail(String email);
Optional<User> findByPhone(String phone);
boolean existsByPhone(String phone);
Optional<User>findUserByid(Long id);
boolean existsById(Long id);


}
