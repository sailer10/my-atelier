package me.sailer.my_atelier.enums.converter;

import jakarta.persistence.AttributeConverter;
import me.sailer.my_atelier.enums.FileStatus;

public class FileStatusConverter implements AttributeConverter<FileStatus, Byte> {

    @Override
    public Byte convertToDatabaseColumn(FileStatus fileStatus) {
        if (fileStatus == null)
            return null;
        return (byte)fileStatus.getCode();
    }

    @Override
    public FileStatus convertToEntityAttribute(Byte code) {
        if (code == null)
            return null;
        return FileStatus.ofCode(code);
    }
}
