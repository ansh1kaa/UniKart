package io.github.ansh1kaa.unikart.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import javax.management.relation.Role;
import java.util.Objects;


@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    @Pattern(regexp = "^(@&$%^*#!?)" , message = "Password should includes at least one special character.")
    @Column(nullable = false)
    private String password;

    /**
     * write you working email.
     * Cannot be blank or null.
     */
    @Email(message = "Please provide a valid email.")
    @Column(nullable = false)
    private String email;

    public void setRole(Role newrole) {
        if (newrole == null) {
            throw new IllegalArgumentException("Role cannot be null.");
        }
        this.role = newRole();
    }

    private String newRole() {
        return "Role can either buyer or seller";
    }

    private String role;

    /**
     * write only 10 digits number.
     * Cannot be blank or null.
     */

   @Pattern(regexp = "^[0-9]{10}$", message = "Phone no. should be 10 digits ."
   )
    @Column(nullable = false)

    private String phone;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public  void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(role, user.role) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, role, id, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }
}
