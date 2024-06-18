package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.enums.AtelierStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAtelierStatusRequest {

    private int status;
}
