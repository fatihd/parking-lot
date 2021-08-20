package com.tarnet.deneme.dao;

import com.tarnet.deneme.domain.Reservation;
import com.tarnet.deneme.domain.Spot;
import com.tarnet.deneme.domain.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<User> list() {
        return sessionFactory.getCurrentSession()
                .createQuery("select u from User u", User.class)
                .list();
    }

    @Override
    public User get(String id) {
        return sessionFactory.getCurrentSession()
                .get(User.class, id);
    }

}