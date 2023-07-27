package ru.kridmi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kridmi.models.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Project> showAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Project  p", Project.class).getResultList();
    }

    @Transactional
    public Project show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Project.class, id);
    }

    @Transactional
    public void create(Project project) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(project);
    }

    @Transactional
    public Project update(Project updateProject, int id) {
        Session session = sessionFactory.getCurrentSession();

        Project projectToBeUpdated = session.get(Project.class, id);
        projectToBeUpdated.setProject(updateProject.getProject());
        return projectToBeUpdated;
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Project.class, id));
    }

    public List<Project> showProj(String projectN) {
        return null;
    }
}
