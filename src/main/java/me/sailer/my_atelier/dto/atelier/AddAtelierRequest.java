package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.enums.AtelierStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddAtelierRequest {

    private String name;
    private String address;
    private byte status;

    public Atelier toEntity() {
        return Atelier.builder()
                .name(name)
                .address(address)
                .status(AtelierStatus.ofCode(status))
                .build();
    }

}
