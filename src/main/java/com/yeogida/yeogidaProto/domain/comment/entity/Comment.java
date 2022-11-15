package com.yeogida.yeogidaProto.domain.comment.entity;

import com.yeogida.yeogidaProto.domain.common.entity.BaseEntity;
import com.yeogida.yeogidaProto.domain.member.entity.Member;
import com.yeogida.yeogidaProto.domain.place.entity.Place;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Comment(String content, Place place, Member member) {
        this.content = content;
        this.place = place;
        this.member = member;
    }
}
