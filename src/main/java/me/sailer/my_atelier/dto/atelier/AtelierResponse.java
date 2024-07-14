package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.enums.AtelierStatus;

import java.time.LocalDateTime;

@Getter
public class AtelierResponse {
    private Long atelier_no;
    private String name;
    private String address;
    private AtelierStatus status;
    private LocalDateTime created_at;

    public AtelierResponse(Atelier atelier) {
        this.atelier_no = atelier.getAtelierNo();
        this.name = atelier.getName();
        this.address = atelier.getAddress();
        this.status = atelier.getStatus();
        this.created_at = atelier.getCreated_at();
    }
}
