package com.yeogida.yeogidaProto.domain.member.service;

import com.yeogida.yeogidaProto.domain.member.entity.Member;
import com.yeogida.yeogidaProto.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        getValidateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void getValidateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    public void update(Long id, String nickname, String imgUrl) {
    }
}
