package com.yeogida.yeogidaProto;

import com.yeogida.yeogidaProto.domain.comment.entity.Comment;
import com.yeogida.yeogidaProto.domain.member.entity.Member;
import com.yeogida.yeogidaProto.domain.member.entity.Role;
import com.yeogida.yeogidaProto.domain.place.entity.Place;
import com.yeogida.yeogidaProto.domain.trip.entity.Region;
import com.yeogida.yeogidaProto.domain.trip.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Member member1 = new Member(Role.USER, "test1@test1", "pass1", "nick1", "www.google1.com");
            Member member2 = new Member(Role.USER, "test1@test2", "pass2", "nick2", "www.google2.com");
            Member member3 = new Member(Role.USER, "test1@test3", "pass3", "nick3", "www.google3.com");
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            Trip trip1 = new Trip("경주", "문화유산", "www.google4.com", Region.경상도, 0, member1);
            Trip trip2 = new Trip("제주", "돌하르방", "www.google5.com", Region.제주도, 0, member2);
            Trip trip3 = new Trip("강남", "핫플레이스", "www.google6.com", Region.서울, 0, member3);
            em.persist(trip1);
            em.persist(trip2);
            em.persist(trip3);

            Place place1 = new Place("불국사", "경주시 oo동", "asda", "너무 좋아요", 5, trip1);
            Place place2 = new Place("석굴암", "경주시 ㅁㅁ동", "asdsda", "너무 멋있어요", 4, trip1);
            em.persist(place1);
            em.persist(place2);

            Comment comment1 = new Comment("사진이 멋있어요", place1, member2);
            Comment comment2 = new Comment("저도 가고싶어요", place1, member3);
            em.persist(comment1);
            em.persist(comment2);
        }
    }
}
