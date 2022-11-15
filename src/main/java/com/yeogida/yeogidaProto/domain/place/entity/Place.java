package com.yeogida.yeogidaProto.domain.place.entity;

import com.yeogida.yeogidaProto.domain.comment.entity.Comment;
import com.yeogida.yeogidaProto.domain.common.entity.BaseEntity;
import com.yeogida.yeogidaProto.domain.trip.entity.Trip;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;
    private String name;
    private String address;
    private String imgUrl;
    private String content;
    private Integer star;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public Place(String name, String address, String imgUrl, String content, Integer star, Trip trip) {
        this.name = name;
        this.address = address;
        this.imgUrl = imgUrl;
        this.content = content;
        this.star = star;
        this.trip = trip;
    }
}
