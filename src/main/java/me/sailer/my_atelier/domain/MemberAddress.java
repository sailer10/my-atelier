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
@Table(name = "MEMBER_ADDRESS")
public class MemberAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short addressNo;

    @ManyToOne
    @JoinColumn(name = "member_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;

    private String name;

    private String receiveName;

    private String receivePhone;

    private int zipcode;            // 우편번호

    private String address;         // 주소. 번지수까지 주소

    private String address_detail;  // 상세주소. 호수, 

    private String address_extra;   // 참고항목 (ex. 동/리/건물명). 도로명주소의 경우 적용됨

    

}
