package com.yeogida.yeogidaProto.domain.trip.repository;

import com.yeogida.yeogidaProto.domain.trip.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
