package me.sailer.my_atelier.dto.atelier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sailer.my_atelier.domain.Atelier;
import me.sailer.my_atelier.enums.AtelierStatus;

import java.time.LocalDateTime;

@Getter
public class AtelierResponse {
    private Long atelierNo;
    private String name;
    private String address;
    private AtelierStatus status;
    private LocalDateTime createdAt;

    public AtelierResponse(Atelier atelier) {
        this.atelierNo = atelier.getAtelierNo();
        this.name = atelier.getName();
        this.address = atelier.getAddress();
        this.status = atelier.getStatus();
        this.createdAt = atelier.getCreatedAt();
    }
}
