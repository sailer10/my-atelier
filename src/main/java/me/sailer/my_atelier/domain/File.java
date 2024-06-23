package me.sailer.my_atelier.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseCreatedTime;
import me.sailer.my_atelier.enums.FileStatus;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "FILE")
public class File extends BaseCreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long file_no;

    @Column(nullable = false)
    private String file_url;

    @Builder.Default
    @Column(nullable = false)
    private FileStatus status = FileStatus.NORMAL;
}
