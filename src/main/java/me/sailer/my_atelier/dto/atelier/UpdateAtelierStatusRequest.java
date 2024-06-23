package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.enums.AtelierStatus;

/**
 * delete 전용
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAtelierStatusRequest {

    private byte status;
}
