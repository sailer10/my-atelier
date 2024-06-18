package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;
import me.sailer.my_atelier.enums.AtelierStatus;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @Column(updatable = false)
    private Byte categoryNo;

    @Column(nullable = false, updatable = false)
    private String name;
}
