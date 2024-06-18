package me.sailer.my_atelier.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 0:관리자, 1:일반유저, 2:공방매니저, 3:공방관리자
 */
@Getter
public enum MemberRole {
    ADMIN("관리자", 1),
    NORMAL("일반유저", 2),
    ATE_MANAGER("공방매니저", 3),
    ATE_MASTER("공방관리자", 4);

    final String desc;
    final int code;

    MemberRole(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static MemberRole ofCode(int code) {
        return Arrays.stream(MemberRole.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원권한코드입니다."));
    }
}
