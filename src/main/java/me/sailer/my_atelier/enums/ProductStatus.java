package me.sailer.my_atelier.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 0:매진, 1:노출, 2:상품노출가림
 */
@Getter
public enum ProductStatus {
    SOLD_OUT("매진", (byte) 0),
    EXPOSED("노출", (byte) 1),
    BLOCKED("가림", (byte) 2),
    BANNED("정책위반", (byte) 3);

    final private String desc;
    final private byte code;

    ProductStatus(String desc, byte code) {
        this.desc = desc;
        this.code = code;
    }

    public static ProductStatus ofCode(byte code) {
        return Arrays.stream(ProductStatus.values())
                .filter(v -> v.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품코드입니다."));
    }
}