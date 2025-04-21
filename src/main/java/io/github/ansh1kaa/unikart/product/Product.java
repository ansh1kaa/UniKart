package io.github.ansh1kaa.unikart.product;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import java.util.Objects;


/**
 * Represents a product listed on UniKart.
 * This entity includes validation constraints to ensure clean and valid product data.
 */
@Entity

public class Product {

    /**
     * Auto-generated unique ID for each product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the product.
     * Cannot be blank or null.
     */
    @NotBlank(message = "Product name is required.")
    @Column(nullable = false)
    private String name;

    /**
     * Description of the product.
     * Cannot be blank or null.
     */
    @NotBlank(message = "Product description is required.")
    @Column(nullable = false)
    private String description;

    /**
     * Price of the product.
     * Must be a positive value (>= 0).
     */
    @NotNull(message = "Product price is required.")
    @Min(value = 0, message = "Product price must be greater than or equal to 0.")
    @Column(nullable = false)
    private double price;

    /**
     * The URL of the product image.
     * Must be a valid URL format.
     */
    @NotBlank(message = "Product image URL is required.")
    @URL(message = "Please provide a valid image URL for the product image.")
    @Column(nullable = false)
    private String imageUrl;

    public Product(Long id) {
    }

    public Product() {

    }

    public Product(Long id, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public Object getQuantity() {
        return null;
    }

    public void setQuantity(Object quantity) {

    }
}
