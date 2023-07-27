package ru.kridmi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kridmi.models.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PositionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PositionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Position> showAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select pos from Position pos", Position.class).getResultList();
    }

    @Transactional
    public Position show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Position.class, id);
    }

    @Transactional
    public void create(Position position) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(position);
    }

    @Transactional
    public Position update(Position updatePosition, int id) {
        Session session = sessionFactory.getCurrentSession();

        Position positionToBeUpdated = session.get(Position.class, id);
        positionToBeUpdated.setPosition(updatePosition.getPosition());

        return positionToBeUpdated;
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Position.class, id));
    }


    public List<Position> showPos(String positionN) {
        return null;
    }
}
