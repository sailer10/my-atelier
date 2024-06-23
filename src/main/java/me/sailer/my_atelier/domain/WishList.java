package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "WISHLIST")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListNo;

    @ManyToOne
    @JoinColumn(name = "member_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member memberNo;

    @ManyToOne
    @JoinColumn(name = "product_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product productNo;
}
