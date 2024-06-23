package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseCreatedTime;
import me.sailer.my_atelier.enums.MemberRole;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@Table(name = "MEMBER")
public class Member extends BaseCreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime pwdModifiedDate;

    @Column(nullable = false)
    private short loginFailCnt;

    // todo: enum,converter MemberStatus 선언할것
    @Column(nullable = false)
    private byte status;

    @Column(nullable = false)
    private MemberRole role = MemberRole.NORMAL;

    private int mileage;

//    @Builder
//    public Member(String id, String name, String email, String phone,
//                  String password, LocalDateTime pwdModifiedDate, short loginFailCnt,
//                  short status, short role) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//        this.pwdModifiedDate = pwdModifiedDate;
//        this.loginFailCnt = loginFailCnt;
//        this.status = status;
//        this.role = role;
//    }

}
