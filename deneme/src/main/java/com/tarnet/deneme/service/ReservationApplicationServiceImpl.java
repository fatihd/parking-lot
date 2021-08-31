package com.tarnet.deneme.service;

import com.tarnet.deneme.dao.ReservationRepository;
import com.tarnet.deneme.domain.Reservation;
import com.tarnet.deneme.domain.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationApplicationServiceImpl implements ReservationApplicationService {
    private final ReservationRepository repository;

    @Override
    public List<Spot> getEmptySpots(LocalDateTime start, LocalDateTime end) {
        return repository.getEmptySpots(start, end);
    }

    @Override
    public void makeReservation(
            long userId,
            long spotId,
            LocalDateTime start,
            LocalDateTime end
    ) throws SpotAlreadyReservedException {

        // TODO cakisma kontrolu

        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        reservation.setSpotId(spotId);
        reservation.setStart(start);
        reservation.setEnd(end);

        repository.save(reservation);
    }

    @Override
    public void cancelReservation(long userId, long reservationId) {
        Reservation reservation = repository.get(reservationId);

        if (userId != reservation.getUserId()) {
            throw new IllegalArgumentException("yetkiniz yok");
        }

        reservation.cancel();
    }
}
