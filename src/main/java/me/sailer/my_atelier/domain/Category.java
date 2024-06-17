package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor//todo: 이 어노테이션 지우기
public class Category {

    @Id
    private byte categoryNo;
    private String name;
}
