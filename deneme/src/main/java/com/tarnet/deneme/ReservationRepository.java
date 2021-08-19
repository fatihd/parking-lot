package com.tarnet.deneme;

import com.tarnet.domain.Reservation;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> list();

    Reservation get(Long id);
}
