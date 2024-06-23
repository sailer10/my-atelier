package me.sailer.my_atelier.enums;

import lombok.Getter;
import me.sailer.my_atelier.enums.common.EnumCommonType;

import java.util.Arrays;

@Getter
public enum FileStatus {
    NORMAL("일반", (byte) 1),
    BANNED("정책위반", (byte) 2);

    final String desc;
    final byte code;

    FileStatus(String desc, byte code) {
        this.desc = desc;
        this.code = code;
    }

    public static FileStatus ofCode(byte code) {
        return Arrays.stream(FileStatus.values())
                .filter(e -> e.getCode() == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 파일코드입니다."));
    }

}
