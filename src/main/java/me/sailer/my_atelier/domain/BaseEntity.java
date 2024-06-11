package me.sailer.my_atelier.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@SuperBuilder   // 자식 객체가 부모 객체의 필드를 builder 패턴으로 사용할 수 있게 함
@MappedSuperclass   // 객체의 입장에서 '생성 시간', '수정 시간' 같은 공통 매핑 정보가 필요할 때 사용됨. 이 어노테이션을 사용함으로써 JPA Entity 클래스들이 BaseTime class 를 상속할경우 BaseTime class의 필드인 createdDate, modifiedDate 를 인식하도록 함.
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // JPA Entity 에서 이벤트가 발생할때마다 특정 로직을 실행시킬 수 있는 어노테이션
public abstract class BaseEntity {

    @CreatedDate
    protected LocalDateTime createdDateTime;

    @LastModifiedDate
    protected LocalDateTime modifiedDateTime;
}
