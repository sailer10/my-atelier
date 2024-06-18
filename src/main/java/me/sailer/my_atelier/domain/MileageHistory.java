package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseCreatedTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MileageHistory extends BaseCreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mileageNo;

    @ManyToOne()
    @JoinColumn(name = "member_no", nullable = false)
    private Member member;

    @Column(nullable = false)
    private int mlgAmount;
}