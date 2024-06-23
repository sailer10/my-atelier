package me.sailer.my_atelier.enums.converter;

import jakarta.persistence.AttributeConverter;
import me.sailer.my_atelier.enums.ProductStatus;

public class ProductStatusConverter implements AttributeConverter<ProductStatus, Byte> {

    @Override
    public Byte convertToDatabaseColumn(ProductStatus status) {
        if (status == null)
            return null;
        return (byte) status.getCode();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Byte code) {
        if (code == null)
            return null;
        return ProductStatus.ofCode(code);
    }
}
