package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseCreatedTime;
import me.sailer.my_atelier.enums.AtelierStatus;
import me.sailer.my_atelier.enums.converter.AtelierStatusConverter;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "atelier")
public class Atelier extends BaseCreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atelier_no;

    private String name;

    private String address;

    // DB 에는 byte(TINYINT)값을 저장하고 프로그램에선 enum을 사용하기 위해 Converter 사용함.
    @Builder.Default
    @Convert(converter = AtelierStatusConverter.class)
    @Column(nullable = false)
    private AtelierStatus status = AtelierStatus.NON_EXPOSED;


    public void update(String name, String address, AtelierStatus status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }

    public void changeAtelierStatus(AtelierStatus status) {
        this.status = status;
    }

}
