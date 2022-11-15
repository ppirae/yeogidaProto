package com.yeogida.yeogidaProto.domain.place.repository;

import com.yeogida.yeogidaProto.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
