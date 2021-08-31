package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.Reservation;
import com.tarnet.deneme.domain.Spot;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Reservation> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("select r from Reservation r", Reservation.class)
                .list();
    }

    @Override
    public Reservation get(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Reservation.class, id);
    }

    //
    @Override
    public List<Spot> getEmptySpots(LocalDateTime start, LocalDateTime end) {
        List<Long> idList = sessionFactory.getCurrentSession()
                .createQuery("select r.spotId from Reservation r where r.end > :start or r.start < :end or r.status = 'CANCELLED'", Long.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();

        if (idList.isEmpty())
            return sessionFactory.getCurrentSession().createQuery("select s from Spot s", Spot.class)
                    .getResultList();

        return sessionFactory.getCurrentSession().createQuery("select s from Spot s where s.id not in :idList", Spot.class)
                .setParameter("idList", idList)
                .getResultList();
    }

    @Override
    public void save(Reservation reservation) {
        sessionFactory.getCurrentSession()
                .merge(reservation);
    }
}