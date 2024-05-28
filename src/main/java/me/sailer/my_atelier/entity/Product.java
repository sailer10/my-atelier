package me.sailer.my_atelier.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "productName")
    private String productName;

    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modifiedAt")
    private LocalDateTime modifiedAt;

    @Builder
    public Product(String name, LocalDateTime date) {
        this.productName = name;
        this.createdAt = date;
        this.modifiedAt = date;
    }

    public void update(String name, LocalDateTime date) {
        this.productName = name;
        this.modifiedAt = date;
    }
}
