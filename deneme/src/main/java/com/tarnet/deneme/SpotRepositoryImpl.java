package com.tarnet.deneme;

import com.tarnet.domain.Spot;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class SpotRepositoryImpl implements SpotRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Spot> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("select u from Spot u", Spot.class)
                .list();
    }

    @Override
    public Spot get(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Spot.class, id);
    }

}