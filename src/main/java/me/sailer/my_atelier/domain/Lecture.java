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
@Table(name = "LECTURE") //todo: @Table 어노테이션에 테이블명 써준거 다 지워야됨. 매핑규칙은 어짜피 따로 정한다
public class Lecture {

    @Id
    @OneToOne
    @JoinColumn(name = "product_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    private String videoUrl;
}
