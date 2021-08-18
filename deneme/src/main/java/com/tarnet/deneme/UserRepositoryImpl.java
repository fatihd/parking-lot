package com.tarnet.deneme;

import com.tarnet.domain.Reservation;
import com.tarnet.domain.Spot;
import com.tarnet.domain.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void insert(){
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < 5; i++) {
            User u = new User();

            u.setAd("Ad " + i);

            for (int j = 0; j < 3; j++) {
                Spot s = new Spot();

                u.addSpots(s);

                for (int k = 0; k< 3; k++){
                    Reservation r = new Reservation();

                    s.addReservations(r);

                }
            }

            session.merge(u);
        }
    }

/*    @Override
    public void delete() {
        Session session = sessionFactory.getCurrentSession();

        User zzzUsers = session.get(User.class, -2L);

        if (!zzzMaster.getAd().contains("DENEME"))
            throw new IllegalArgumentException("bu kayit silinemez!");

        session.delete(zzzUsers);
    }*/

    @Override
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("select u from User u", User.class);

        return query.list();
    }

}