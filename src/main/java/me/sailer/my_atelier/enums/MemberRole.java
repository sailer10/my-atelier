package me.sailer.my_atelier.enums;

import lombok.Getter;
import me.sailer.my_atelier.enums.common.EnumCommonType;

import java.util.Arrays;

/**
 * 0:관리자, 1:일반유저, 2:공방매니저, 3:공방관리자
 */
@Getter
public enum MemberRole  {
    NORMAL("일반유저", (byte) 1),
    ADMIN("관리자", (byte) 2),
    ATE_MANAGER("공방매니저", (byte) 3),
    ATE_MASTER("공방관리자", (byte) 4);

    final String desc;
    final byte code;

    MemberRole(String desc, byte code) {
        this.desc = desc;
        this.code = code;
    }

    public static MemberRole ofCode(byte code) {
        return Arrays.stream(MemberRole.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원권한코드입니다."));
    }
}
