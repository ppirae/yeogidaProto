package com.yeogida.yeogidaProto.domain.member.request;

import com.yeogida.yeogidaProto.domain.member.response.MemberDto;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class MemberRequestMapper {

    public MemberDto toDto(OAuth2User oAuth2User){
        var attributes = oAuth2User.getAttributes();
        return MemberDto.builder()
                .email((String) attributes.get("email"))
                .nickname((String) attributes.get("nickname"))
                .profileImgUrl((String) attributes.get("profileImgUrl"))
                .build();
    }

//    public MemberFindRequest toFindDto(MemberDto memberDto) {
//        return new MemberFindRequest(memberDto.getEmail());
//    }
}
