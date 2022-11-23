package com.yeogida.yeogidaProto.domain.member.repository;

import com.yeogida.yeogidaProto.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    boolean existsByEmail(String email);
    Member findByNickname(String nickname);
}
