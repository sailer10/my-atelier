package me.sailer.my_atelier.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class Atelier extends BaseCreatedTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atelierNo;

    private String name;
    private String address;
}
