package me.sailer.my_atelier.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EnumCategory {
    OTHER("기타", (byte)0),
    LEATHER("가죽", (byte)1),
    CARPENTRY("목공", (byte)2),
    BAKING("베이킹", (byte)3),
    POTTERY("도자기", (byte)4),
    PERFUME("향수", (byte)5);

    final private String desc;
    final private byte code;

    EnumCategory(String desc, byte code) {
        this.desc = desc;
        this.code = code;
    }

    public static EnumCategory ofCode(byte code) {
        return Arrays.stream(EnumCategory.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 카테고리코드 입니다"));
    }
}
