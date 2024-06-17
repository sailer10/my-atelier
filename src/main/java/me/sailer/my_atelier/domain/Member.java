package me.sailer.my_atelier.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
public class Member extends BaseCreatedTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private LocalDateTime pwdModifiedDate;

    private short loginFailCnt;

    private short status;

    private short role;

    @Builder
    public Member(String id, String name, String email, String phone,
                  String password, LocalDateTime pwdModifiedDate, short loginFailCnt,
                  short status, short role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.pwdModifiedDate = pwdModifiedDate;
        this.loginFailCnt = loginFailCnt;
        this.status = status;
        this.role = role;
    }

}
