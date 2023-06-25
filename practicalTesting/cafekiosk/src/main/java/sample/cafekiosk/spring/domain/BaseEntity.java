package sample.cafekiosk.spring.domain;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public abstract class BaseEntity { // 인스턴스 필요 없 -> 추상

    @CreatedDate
    private LocalDateTime localDateTime;

    @LastModifiedDate
    private LocalDateTime modifiedDateTime;
}
