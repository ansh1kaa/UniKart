package io.github.ansh1kaa.unikart.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findUserByid(id)
                .orElseThrow(() -> new RuntimeException("User not found with this id: "));
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found by email"));
    }

    public User updateUser(Long id, User updateUser) {
        User user = getUserById(id);
        user.setEmail(updateUser.getEmail());
        user.setUsername(updateUser.getUsername());
        user.setPhone(updateUser.getPhone());
        user.setPassword(updateUser.getPassword());
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
    }
}

















//    UserService() {
//
//        User changeEmail = new User();
//        User loginUser = new User();
//        User logoutUser = new User();
//        User registerUser = new User();
//        User changePassword = new User();
//        User forgotPassword = new User();
//        User resetPassword = new User();
//        User updateProfile = new User();
//        User deleteUser = new User();
//        User changepassword = new User();
//        User changeusername = new User();
//        User changephone = new User();
//
//
//    }


