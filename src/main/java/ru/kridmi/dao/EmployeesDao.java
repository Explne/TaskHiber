package ru.kridmi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kridmi.models.Employee;

import java.util.List;


@Component
public class EmployeesDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeesDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Employee> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Transactional
    public Employee show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Employee.class, id);
    }

    @Transactional
    public void create(Employee employee) {
    Session session = sessionFactory.getCurrentSession();

    session.persist(employee);
    }

    @Transactional
    public void update(int id, Employee updatedEmployee) {
    Session session = sessionFactory.getCurrentSession();

    Employee employeeToBeUpdated = session.get(Employee.class, id);
    employeeToBeUpdated.setFirstname(updatedEmployee.getFirstname());
    employeeToBeUpdated.setLastname(updatedEmployee.getLastname());
    employeeToBeUpdated.setAge(updatedEmployee.getAge());
    }

    @Transactional
    public void delete(int id) {
    Session session = sessionFactory.getCurrentSession();

    session.remove(session.get(Employee.class, id));
    }

    public List<Employee> showProjects() {
        return null;
    }

    public List<Employee> showProjectsEmp(String lastname) {

        return null;
    }
}
