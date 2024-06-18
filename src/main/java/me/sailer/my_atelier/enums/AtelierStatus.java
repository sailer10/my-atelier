package me.sailer.my_atelier.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 검색에 노출안됨, 가게활성화, 임시휴업, 권한박탈
 */
@Getter
public enum AtelierStatus {
    NON_EXPOSED("노출안됨", 0),
    ACTIVE("활성화", 1),
    TEMP_CLOSED("임시휴업", 2),
    BANNED("권한박탈", 3),
    SHUTDOWN("폐업", 4);

    final private String desc;
    final private int code;

    AtelierStatus(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static AtelierStatus ofCode(int code) {
        return Arrays.stream(AtelierStatus.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공방코드입니다."));
    }
}
