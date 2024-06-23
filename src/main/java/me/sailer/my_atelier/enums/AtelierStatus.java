package me.sailer.my_atelier.enums;

import lombok.Getter;
import me.sailer.my_atelier.enums.common.EnumCommonType;

import java.util.Arrays;

/**
 * 검색에 노출안됨, 가게활성화, 임시휴업, 권한박탈
 */
@Getter
public enum AtelierStatus {
    NON_EXPOSED("노출안됨", (byte)0),
    ACTIVE("활성화", (byte)1),
    TEMP_CLOSED("임시휴업", (byte)2),
    BANNED("권한박탈", (byte)3),
    SHUTDOWN("폐업", (byte)4);

    final private String desc;
    final private byte code;

    AtelierStatus(String desc, byte code) {
        this.desc = desc;
        this.code = code;
    }

    public static AtelierStatus ofCode(byte code) {
        return Arrays.stream(AtelierStatus.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공방코드입니다."));
    }
}
