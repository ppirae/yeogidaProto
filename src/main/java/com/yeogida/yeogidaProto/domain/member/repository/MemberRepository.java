package com.yeogida.yeogidaProto.domain.member.repository;

import com.yeogida.yeogidaProto.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByEmail(String email);
    List<Member> findByNickname(String nickname);
}
