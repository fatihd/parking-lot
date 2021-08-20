package com.tarnet.web;

import com.tarnet.deneme.domain.Reservation;
import com.tarnet.deneme.domain.Spot;

import java.util.ArrayList;
import java.util.List;

public class ReservationDtoFactory {

    public static ReservationDto createFromReservation(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setSpotId(reservation.getSpotId());
        return reservationDto;
    }

    static List<ReservationDto> createFromReservationList(List<Reservation> list) {
        List<ReservationDto> sonuc = new ArrayList<>();

        for (Reservation s : list)
            sonuc.add(createFromReservation(s));
        return sonuc;
    }

}
