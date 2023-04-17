package jpabook.jpashop.repository;

import java.util.List;
import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {// type, id
    List<Member> findByName(String name); // findByxxx -> select m from Member m where m.name(xxx) = :name (xxx)
}
