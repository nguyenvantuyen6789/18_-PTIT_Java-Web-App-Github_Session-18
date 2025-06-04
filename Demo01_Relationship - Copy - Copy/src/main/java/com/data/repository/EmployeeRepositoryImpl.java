package com.data.repository;

import com.data.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private SessionFactory sessionFactory;

    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();

        // hql
        Query<Employee> query = session.createQuery("FROM Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
