package com.yeogida.yeogidaProto.domain.member.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {

    private String email;
    private String nickname;
    private String profileImgUrl;

    @Builder
    public MemberDto(String email, String nickname, String profileImgUrl) {
        this.email = email;
        this.nickname = nickname;
        this.profileImgUrl = profileImgUrl;
    }
}
