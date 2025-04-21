package io.github.ansh1kaa.unikart.buyer;

import io.github.ansh1kaa.unikart.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
public class Buyer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the user.
     * Cannot be blank or null.
     */
    @NotBlank(message = "Username name is required.")
    @Column(nullable = false)
    private String username;

    /**
     * give strong password.
     * Cannot be blank or null.
     */
    @Pattern(regexp = "^(@&$%^*#!?)" , message = "Password should includes at least one special character @&$%^*#!?  .")
    @Column(nullable = false)
    private String password;


    /**
     * write you working email.
     * Cannot be blank or null.
     */
    @Email(message = "Please provide a valid email.")
    @Column(nullable = false)
    private String email;

    /**
     * write only 10 digits number.
     * Cannot be blank or null.
     */

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone no. should be 10 digits ."
    )
    @Column(nullable = false)
    private String phone;


    // Getters and Setters

    public long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(username, buyer.username) && Objects.equals(password, buyer.password) && Objects.equals(email, buyer.email) && Objects.equals(phone, buyer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, phone);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


