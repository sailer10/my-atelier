package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
