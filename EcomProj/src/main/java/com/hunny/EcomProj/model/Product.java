package com.hunny.EcomProj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @jakarta.persistence.Id
    private int Id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;
    //for adding image in database and client side
private String imageName;
    private  String imageType;
    @Lob
    private byte[] imageData;
   public Product(int id){
        this.Id= id;
    }
}
