package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.Reservation;
import com.tarnet.deneme.domain.Spot;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository {
    List<Reservation> list();

    Reservation get(Long id);

    List<Spot> getEmptySpots(LocalDateTime start, LocalDateTime end);

    void save(Reservation reservation);
}
