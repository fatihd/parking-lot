package com.tarnet.deneme;

import com.tarnet.domain.ZzzDetail;
import com.tarnet.domain.ZzzMaster;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@RequiredArgsConstructor
public class MasterRepositoryImpl implements MasterRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void insert() {
        Session session = sessionFactory.getCurrentSession();

        for (int i = 0; i < 5; i++) {
            ZzzMaster m = new ZzzMaster();

            m.setAd("Ad " + i);

            for (int j = 0; j < 3; j++) {
                ZzzDetail d = new ZzzDetail();
                d.setNumara(j);

                m.detayEkle(d);
            }

            session.merge(m);
        }

    }

    @Override
    public void update() {
        Session session = sessionFactory.getCurrentSession();

        ZzzMaster zzzMaster = session.get(ZzzMaster.class, 1002L);

        zzzMaster.setAd(zzzMaster.getAd() + " ******** ");
    }

    @Override
    public void delete() {
        Session session = sessionFactory.getCurrentSession();

        ZzzMaster zzzMaster = session.get(ZzzMaster.class, -2L);

        if (!zzzMaster.getAd().contains("DENEME"))
            throw new IllegalArgumentException("bu kayit silinemez!");

        session.delete(zzzMaster);
    }

    @Override
    public void showOne() {
        Session session = sessionFactory.getCurrentSession();

        List<ZzzMaster> list = session.createCriteria(ZzzMaster.class)
                .add(Restrictions.eq("id",1031L))
                .list();

        System.out.println(list.get(0).getAd());
    }

    @Override
    public List<ZzzMaster> list() {
        Session session = sessionFactory.getCurrentSession();

        Query<ZzzMaster> query = session.createQuery("select m from ZzzMaster m", ZzzMaster.class);

        return query.list();
    }
}
