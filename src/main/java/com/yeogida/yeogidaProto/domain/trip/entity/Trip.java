package com.yeogida.yeogidaProto.domain.trip.entity;

import com.yeogida.yeogidaProto.domain.common.entity.BaseEntity;
import com.yeogida.yeogidaProto.domain.member.entity.Member;
import com.yeogida.yeogidaProto.domain.place.entity.Place;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trip extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;
    private String name;
    private String smallTitle;
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private Region region;
    private Integer likesNum;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    public Trip(String name, String smallTitle, String imgUrl, Region region, Integer likesNum, Member member) {
        this.name = name;
        this.smallTitle = smallTitle;
        this.imgUrl = imgUrl;
        this.region = region;
        this.likesNum = likesNum;
        this.member = member;
    }
}
