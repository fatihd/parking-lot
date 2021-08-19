package com.tarnet.web;

import com.tarnet.deneme.ReservationRepository;
import com.tarnet.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<ReservationDto>> listele(){

        List<Reservation> list = reservationRepository.list();

        List<ReservationDto> sonuc = ReservationDtoFactory.createFromReservationList(list);

        return ResponseEntity.ok(sonuc);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ReservationDto> get(@PathVariable("id") String id) {

        Reservation reservation = reservationRepository.get(Long.valueOf(id));

        ReservationDto reservationDto = ReservationDtoFactory.createFromReservation(reservation);

        return ResponseEntity.ok(reservationDto);
    }

}
