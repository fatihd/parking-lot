package com.tarnet.web;

import com.tarnet.domain.Reservation;
import com.tarnet.domain.Spot;

import java.util.ArrayList;
import java.util.List;

public class ReservationDtoFactory {

    public static ReservationDto createFromReservation(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setSpot(createSpotDto(reservation.getSpot()));
        return reservationDto;
    }

    private static ReservationDto.SpotDto createSpotDto(Spot spot) {
        ReservationDto.SpotDto spotDto = new ReservationDto.SpotDto();
        spotDto.setId(spot.getId());
        return spotDto;
    }

    static List<ReservationDto> createFromReservationList(List<Reservation> list) {
        List<ReservationDto> sonuc = new ArrayList<>();

        for (Reservation s : list)
            sonuc.add(createFromReservation(s));
        return sonuc;
    }

}
