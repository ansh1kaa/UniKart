package io.github.ansh1kaa.unikart.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST API Controller for user operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/register")
    public User register(User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest){
        try {
            User user = userService.getUserByEmail(loginRequest.getEmail());
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok("Login successful" + user.getRole());
            }
            else {
                return ResponseEntity.badRequest().body("Login failed");

            }

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Login failed");
        }
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return null;
    }
    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @PutMapping("/switch-role/{id}")
    public ResponseEntity<String> switchRole(@PathVariable Long id) {
        return ResponseEntity.ok("Role changed successfully.");
    }

    @PutMapping("/update-password/{id}")
    public ResponseEntity<String> updatePassword(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok("Password updated successfully.");
    }
    @PutMapping("/update-name/{id}")
    public ResponseEntity<String> updateName(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok("Name updated successfully.");
    }




}
