package com.tarnet.deneme;

import com.tarnet.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

}