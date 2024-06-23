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
@Table(name = "ATELIER_MANAGER")
public class AtelierManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manager_no;

    @OneToOne
    @JoinColumn(name = "member_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;

    @ManyToOne
    @JoinColumn(name = "atelier_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Atelier atelier;

    private byte role;  //master, manager
}
