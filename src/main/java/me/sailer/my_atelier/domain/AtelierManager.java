package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
public class AtelierManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerNo;


    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member memberNo;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Atelier atelierNo;

    private short role;
}
