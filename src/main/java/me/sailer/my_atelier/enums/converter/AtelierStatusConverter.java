package me.sailer.my_atelier.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import me.sailer.my_atelier.enums.AtelierStatus;

@Converter
public class AtelierStatusConverter implements AttributeConverter<AtelierStatus, Byte> {

    @Override
    public Byte convertToDatabaseColumn(AtelierStatus status) {
        if (status == null)
            return null;
        return (byte) status.getCode();
    }

    @Override
    public AtelierStatus convertToEntityAttribute(Byte code) {
        if (code == null)
            return null;
        return AtelierStatus.ofCode(code);

    }
}
