package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

//    @NotEmpty 별도의 dto를 활용하여 설정해주는것이 정석
    private String name;

    @Embedded
    private Address address;

//    @JsonIgnore api 조회에서 제외시키기
    @OneToMany(mappedBy = "member") // 읽기전용
    private List<Order> orders = new ArrayList<>(); // 컬렉션은 필드에서 초기화하자. 하이버네이트 내부 매커니즘 문제를발생시킬수있음 바꾸지 말기

}
