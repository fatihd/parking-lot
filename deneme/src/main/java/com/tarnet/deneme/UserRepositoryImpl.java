package com.tarnet.deneme;

import com.tarnet.domain.ZzzMaster;
import com.tarnet.domain.ZzzReservations;
import com.tarnet.domain.ZzzSpots;
import com.tarnet.domain.ZzzUsers;
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
public class UsersRepositoryImpl implements UsersRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void insert(){
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < 5; i++) {
            ZzzUsers u = new ZzzUsers();

            u.setAd("Ad " + i);

            for (int j = 0; j < 3; j++) {
                ZzzSpots s = new ZzzSpots();

                u.addSpots(s);

                for (int k = 0; k< 3; k++){
                    ZzzReservations r = new ZzzReservations();

                    s.addReservations(r);

                }
            }

            session.merge(u);
        }
    }

/*    @Override
    public void delete() {
        Session session = sessionFactory.getCurrentSession();

        ZzzUsers zzzUsers = session.get(ZzzUsers.class, -2L);

        if (!zzzMaster.getAd().contains("DENEME"))
            throw new IllegalArgumentException("bu kayit silinemez!");

        session.delete(zzzUsers);
    }*/

    @Override
    public List<ZzzUsers> list() {
        Session session = sessionFactory.getCurrentSession();

        Query<ZzzUsers> query = session.createQuery("select u from ZzzUsers u", ZzzUsers.class);

        return query.list();
    }

}