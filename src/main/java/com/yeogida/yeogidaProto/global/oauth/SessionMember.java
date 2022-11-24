package com.yeogida.yeogidaProto.global.oauth;

import com.yeogida.yeogidaProto.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
public class SessionMember implements Serializable {
    private String email;
    private String nickname;
    private String profileImgUrl;

    public SessionMember(Member member) {
        this.email = member.getEmail();
        this.nickname = member.getNickname();
        this.profileImgUrl = member.getProfileImgUrl();
    }
}
