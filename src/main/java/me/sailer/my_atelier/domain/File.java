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
    @Column(name = "file_no")
    private Long fileNo;

    @Column(nullable = false, name = "file_src")
    private String fileSrc;

    @Builder.Default
    @Column(nullable = false)
    private FileStatus status = FileStatus.NORMAL;
}
