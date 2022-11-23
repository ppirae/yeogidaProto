package com.yeogida.yeogidaProto.domain.member.entity;

import com.yeogida.yeogidaProto.domain.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String profileImgUrl;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @Builder
    public Member(String email, String nickname, String profileImgUrl) {
        this.email = email;
        this.nickname = nickname;
        this.profileImgUrl = profileImgUrl;
    }

    public Member update(String nickname, String profileImgUrl) {
        this.nickname = nickname;
        this.profileImgUrl = profileImgUrl;

        return this;
    }
}



