package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.enums.AtelierStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAtelierRequest {

    private String name;
    private String address;
    private AtelierStatus status;
}
