package me.sailer.my_atelier.enums.converter;

import jakarta.persistence.AttributeConverter;
import me.sailer.my_atelier.enums.MemberRole;

public class MemberRoleConverter implements AttributeConverter<MemberRole, Byte> {

    @Override
    public Byte convertToDatabaseColumn(MemberRole status) {
        if (status == null)
            return null;
        return (byte) status.getCode();
    }

    @Override
    public MemberRole convertToEntityAttribute(Byte code) {
        if (code == null)
            return null;
        return MemberRole.ofCode(code);
    }
}
