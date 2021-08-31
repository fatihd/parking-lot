package com.tarnet.deneme.service;

import com.tarnet.deneme.domain.Spot;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationApplicationService {

    List<Spot> getEmptySpots(LocalDateTime start, LocalDateTime end);

    // ayni spot kesisen araliklarda reserve edilemez.
    void makeReservation(long userId, long spotId, LocalDateTime start, LocalDateTime end)
            throws SpotAlreadyReservedException;

    // ayni spot kesisen araliklarda reserve edilemez.
    void cancelReservation(long userId, long reservationId);

    class SpotAlreadyReservedException extends Exception {}
}
