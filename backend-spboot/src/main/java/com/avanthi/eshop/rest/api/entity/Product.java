package com.avanthi.eshop.rest.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Product Name should not be empty")
    @Size(min = 3, max = 100, message = "title should be between 3 to 100 characters")
    @Column(name = "Product Name", nullable = false)
    private String name;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 10, message = "title should be minimum 10 characters")
    @Column(name = "description", nullable = false)
    private String description;


    @Column(name = "Price")
    private double price;


    @Column(name = "Stock")
    private int stock;

    @NotEmpty(message = "Image should not be empty")
    @Column(name = "image", nullable = false)
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
