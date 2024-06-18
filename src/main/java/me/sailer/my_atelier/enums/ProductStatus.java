package me.sailer.my_atelier.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 0:매진, 1:노출, 2:상품노출가림
 */
@Getter
public enum ProductStatus {
    SOLD_OUT("매진", 0),
    EXPOSED("노출", 1),
    BLOCKED("가림", 2),
    BANNED("정책위반", 3);

    final private String desc;
    final private int code;

    ProductStatus(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    public static MemberRole ofCode(int code) {
        return Arrays.stream(MemberRole.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품코드입니다."));
    }
}